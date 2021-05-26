package Logic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Network extends Thread {
    private int myID;
    private final static int SERVER_PORT_OFFSET = 9000;
    private Controller controller = null;

    /* Methods */
    Network(Controller controller){
        this.controller = controller;
    }
    /*  Functionality :
            thread로 계속 돌면서 응답해야할 메시지들에 응답함.
    *   Parameters : void
    *   Return value : void
    *  */
    public void run(){
        /* 소켓 기본 설정 */
        ServerSocket serverSocket = null;
        Socket socket = null;
        Msg sendMsg = null;

        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            serverSocket = new ServerSocket(SERVER_PORT_OFFSET + this.myID);
            System.out.println("Server Running");

            while (true) {
                socket= serverSocket.accept();
                System.out.println("Client connected");

                objectInputStream = new ObjectInputStream(socket.getInputStream());
                Msg msg = (Msg) objectInputStream.readObject();
                System.out.println("Receive Msg:"+msg.getSrc_id()+" "+msg.getDst_id()+" "+msg.getType()+" "+msg.getDescription());
                /* Network 응답 구현부 */
                int type = msg.getType();
                /*  this function uses these Msg types.
                        1 : 자판기 시작 요청 및 주소
                        3 : 자판기 종료
                        4 : 재고 여부 요청
                        6 : 인증코드 생성 요청
                * */
                switch (type) {
                    case 1:
                        /* 해당 자판기를 VMList에 추가하고 주소 응답을 보냄(operating) */
                        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        sendMsg = new Msg(myID, msg.getSrc_id(), 2, controller.getMyAddress());
                        controller.addVM(msg.getSrc_id(), msg.getDescription());
                        objectOutputStream.writeObject(sendMsg);
                        objectOutputStream.flush();
                        break;
                    case 3:
                        /* 해당 자판기르르 VMList에서 제거함 */
                        controller.deleteVM(msg.getSrc_id());
                        break;
                    case 4:
                        /* 재고 여부를 응답함 */
                        boolean available = controller.checkStock(Integer.parseInt(msg.getDescription()));
                        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        sendMsg = new Msg(myID, msg.getSrc_id(), 5, Boolean.toString(available));
                        objectOutputStream.writeObject(sendMsg);
                        objectOutputStream.flush();
                        break;
                    case 6:
                        int menu = Integer.parseInt(msg.getDescription());
                        boolean stockAvailable = controller.checkStock(menu);
                        /* 재고가 있으므로 인증코드 생성 */
                        if (stockAvailable) {
                            String code = controller.makeVerificationCode(menu);
                            /* 인증코드 생성 성공 */
                            if(code != null){
                                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                                sendMsg = new Msg(myID, msg.getSrc_id(), 7, code);         //인증코드 변경 가능
                            }
                            /* 인증코드 개수 초과로 생성 실패 */
                            else{
                                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                                sendMsg = new Msg(myID, msg.getSrc_id(), 8, null);
                            }
                        /* 재고가 없어 환불 요청 */
                        } else {
                            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                            sendMsg = new Msg(myID, msg.getSrc_id(), 8, null);
                        }
                        objectOutputStream.writeObject(sendMsg);
                        objectOutputStream.flush();
                        break;
                }
                if(type!=3) {
                    System.out.println("Send Msg:" + sendMsg.getSrc_id() + " " + sendMsg.getDst_id() + " " + sendMsg.getType() + " " + sendMsg.getDescription());
                }
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void requestVmOn(String address){
        Socket socket = null;
        for(int i=1;i<11;i++) {
            if(myID != i) {
                try {
                    socket = new Socket("localhost", SERVER_PORT_OFFSET + i);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                    Msg msg = new Msg(myID, i, 1, address);
                    objectOutputStream.writeObject(msg);
                    objectOutputStream.flush();
                    System.out.println("Send Msg:"+msg.getSrc_id()+" "+msg.getDst_id()+" "+msg.getType()+" "+msg.getDescription());

                    /* 응답으로 받은 DVM을 VMList에 추가 */
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    Msg receivedMsg = (Msg) objectInputStream.readObject();
                    controller.addVM(i, receivedMsg.getDescription());
                    System.out.println("Receive Msg:"+receivedMsg.getSrc_id()+" "+receivedMsg.getDst_id()+" "+receivedMsg.getType()+" "+receivedMsg.getDescription());
                    socket.close();
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("ID: "+i+" 자판기가 종료 상태 입니다.");
                }
            }
        }
    }


    public void requestVmOff(){
        boolean[] operating = controller.getOperating();
        Socket socket = null;
        for(int i=1;i<11;i++) {
            if(operating[i-1]) {
                try {
                    socket = new Socket("localhost", SERVER_PORT_OFFSET + i);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                    Msg msg = new Msg(myID, i, 3, null);
                    objectOutputStream.writeObject(msg);
                    objectOutputStream.flush();
                    System.out.println("Send Msg:"+msg.getSrc_id()+" "+msg.getDst_id()+" "+msg.getType()+" "+msg.getDescription());

                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /*  Functionality :
            myID를 제외한 1부터 10까지의 DVM에게 모두 음료번호에 대한 재고 여부 요청 메시지를 발송함.
            재고 여부가 있다고 응답한
    *   Parameters :
    *   Return values :
    *       null :
    *       boolean[] : 재고가 있다고 응답한 자판기
    * */
    public boolean[] requestStock(int beverageID){
        boolean[] operating = controller.getOperating();
        boolean[] availableList = new boolean[10];
        Socket socket = null;
        /* availableList 초기화 */
        for(int i=0;i<10;i++){
            availableList[i] = false;
        }
        /* broadcast로 재고 여부 요청 메시지 발송 */
        for(int i=1;i<11;i++) {
            if(operating[i-1]) {
                try {
                    socket = new Socket("localhost", SERVER_PORT_OFFSET + i);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                    Msg msg = new Msg(myID, i, 4, Integer.toString(beverageID));
                    objectOutputStream.writeObject(msg);
                    objectOutputStream.flush();
                    System.out.println("Send Msg:"+msg.getSrc_id()+" "+msg.getDst_id()+" "+msg.getType()+" "+msg.getDescription());

                    /* 재고 여부가 true인 자판기들을 추가 */
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    Msg receivedMsg = (Msg) objectInputStream.readObject();
                    System.out.println("Receive Msg:"+receivedMsg.getSrc_id()+" "+receivedMsg.getDst_id()+" "+receivedMsg.getType()+" "+receivedMsg.getDescription());

                    if(Boolean.parseBoolean(receivedMsg.getDescription())){
                        availableList[i-1] = true;
                    }
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return availableList;
    }

    public String requestVerificationCode(int dst_id, int beverageID){
        /* 보내는 부분 */
        String code = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost",SERVER_PORT_OFFSET+dst_id);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            Msg msg = new Msg(myID,dst_id,6,Integer.toString(beverageID));
            objectOutputStream.writeObject(msg);
            objectOutputStream.flush();
            System.out.println("Send Msg:"+msg.getSrc_id()+" "+msg.getDst_id()+" "+msg.getType()+" "+msg.getDescription());

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Msg receivedMsg = (Msg) objectInputStream.readObject();
            System.out.println("Receive Msg:"+receivedMsg.getSrc_id()+" "+receivedMsg.getDst_id()+" "+receivedMsg.getType()+" "+receivedMsg.getDescription());

            code = receivedMsg.getDescription();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        /* 환불 부분 */
        if(code == null){
            controller.refund();
        }

        /* 응답 받은 msg description을 보고 인증코드를 반환하거나, null을 반환함. */
        return code;
    }

    public void setMyID(int id){
        this.myID = id;
    }

/*    public String[] requestStock(int beverageID){
        String[] stockAvailable = new String[10];

        return stockAvailable;
    }

    public void sendVerificationCode(String code){

        Socket s = null;
        try {
            s = new Socket("localhost",9000+1Controller getMy des_id);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            Msg msg = new Msg(1Controller에 getMy src_id,1Controller getMy des_id,7,"음료번호");
            oos.writeObject(msg);
            oos.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void requestRefund(){
        Socket s = null;
        try {
            s = new Socket("localhost",9000+dst_id);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            Msg msg = new Msg(1Controller에 getMy src_id,dst_id,6,"음료번호");
            oos.writeObject(msg);
            oos.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendOperating(String address){

    }*/


}