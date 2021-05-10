import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Network extends Thread {
    private final static int SERVER_PORT = 9000;
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
            serverSocket = new ServerSocket(SERVER_PORT+1/*Controller getMy des_id*/);
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
                        if(/*해당 제품의 재고가 있으면*/) {
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

    public String[] requestStock(int beverageID){

        //여기 리턴이 String[]인데 Controller에도 리턴을 이렇게 해서 어떻게 수정할지 모르겠음
        Socket s = null;
        try {
            s = new Socket("localhost",9000+1/*Controller에 getMy dst_id*/);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            Msg msg = new Msg(1/*Controller에 getMy src_id*/,1/*Controller에 getMy dst_id*/,4,"음료번호");
            oos.writeObject(msg);
            oos.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void requestVerificationCode(int dst_id, int beverageID){
        Socket s = null;
        try {
            s = new Socket("localhost",9000+dst_id);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            Msg msg = new Msg(1/*Controller에 getMy src_id*/,dst_id,6,"음료번호");
            oos.writeObject(msg);
            oos.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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