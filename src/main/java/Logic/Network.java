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
        PrintWriter printWriter = null;

        try{
            serverSocket = new ServerSocket(SERVER_PORT_OFFSET+this.myID);
            System.out.println("Server Running");

            while(true){
                socket = serverSocket.accept();
                System.out.println("Client connected");
                printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

                objectInputStream = new ObjectInputStream(socket.getInputStream());
                Msg msg = (Msg)objectInputStream.readObject();

                /* Network 응답 구현부 */
                int type = msg.getType();
                /*  this function uses these Msg types.
                        1 : 자판기 시작 요청 및 주소
                        3 : 자판기 종료
                        4 : 재고 여부 요청
                        6 : 인증코드 생성 요청
                * */
                switch(type){
                    case 1:
                        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        sendMsg = new Msg(msg.getDst_id(),msg.getSrc_id(),2,"주소");
                        objectOutputStream.writeObject(sendMsg);
                        objectOutputStream.flush();
                        break;

                    case 2:
                        //addOperatingList()
                        break;
                    case 3:
                        //deleteVM
                        break;
                    case 4:
                        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        sendMsg = new Msg(msg.getDst_id(),msg.getSrc_id(),5,"재고 유/무");
                        objectOutputStream.writeObject(sendMsg);
                        objectOutputStream.flush();
                        break;

                    case 5:
                        //receiveStock()
                        break;
                    case 6:
                        //checkStockVerification()
                        /* 해당 제품의 재고가 있으면*/
                        /***************************************************************/
                        if(true) {
                            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                            sendMsg = new Msg(msg.getDst_id(),msg.getSrc_id(),7,"인증코드");
                            objectOutputStream.writeObject(sendMsg);
                            objectOutputStream.flush();
                            break;
                        }else{
                            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                            sendMsg = new Msg(msg.getDst_id(),msg.getSrc_id(),8,null);
                            objectOutputStream.writeObject(sendMsg);
                            objectOutputStream.flush();
                            break;
                        }

                    case 7:
                        //showVerificationCode()
                        break;
                    case 8:
                        //refund()
                        break;
                }

                printWriter.write("ok");
                printWriter.close();
                socket.close();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void requestVmOn(String address){
        Socket s = null;
        try {
            s = new Socket("localhost",9000+1/*Controller getMy des_id*/);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            Msg msg = new Msg(1/*Controller에 getMy src_id*/,1/*Controller getMy des_id*/,1,address);
            oos.writeObject(msg);
            oos.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void requestVmOff(){
        Socket s = null;
        try {
            s = new Socket("localhost",9000+1/*Controller getMy des_id*/);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            Msg msg = new Msg(1/*Controller에 getMy src_id*/,1/*Controller getMy des_id*/,3,null);
            oos.writeObject(msg);
            oos.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*  Functionality :
            myID를 제외한 1부터 10까지의 DVM에게 모두 음료번호에 대한 재고 여부 요청 메시지를 발송함.
            재고 여부가 있다고 응답한
    *   Parameters :
    *   Return values :
    *       null :
    *       String[] : 재고가 있다고
    * */
    public boolean[] requestStock(int beverageID){
        boolean[] availableList = new boolean[10];

        /*//여기 리턴이 String[]인데 Controller에도 리턴을 이렇게 해서 어떻게 수정할지 모르겠음
        Socket s = null;
        try {
            s = new Socket("localhost",9000+1*//*Controller에 getMy dst_id*//*);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            Msg msg = new Msg(1*//*Controller에 getMy src_id*//*,1*//*Controller에 getMy dst_id*//*,4,"음료번호");
            oos.writeObject(msg);
            oos.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /* myID를 제외한 1~10번 DVM에 requestStock 메시지를 발송함 */
        for(int i=1;i<11;i++){
            availableList[i] = false;
            if(i != myID){
                /* 해당 DVM의 포트에 연결하여 응답을 차례로 받음 */

            }
        }
        return availableList;
    }

    public String requestVerificationCode(int dst_id, int beverageID){
        /* 보내는 부분 */
        Socket s = null;
        try {
            s = new Socket("localhost",SERVER_PORT_OFFSET+dst_id);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            Msg msg = new Msg(myID,dst_id,6,Integer.toString(beverageID));
            oos.writeObject(msg);
            oos.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* 받는 부분 */

        /* 응답 받은 msg type과 description을 보고 인증코드를 반환하거나, "Refund"를 반환함. */

        /* 환불 부분 */
        controller.refund();
        return "Refund";
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