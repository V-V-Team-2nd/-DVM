package Logic;

import java.io.BufferedWriter;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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

        ObjectInputStream objectInputStream = null;
        PrintWriter printWriter = null;

        try{
            serverSocket = new ServerSocket(SERVER_PORT);
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
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 6:
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

    public void requestStock(int beverageID){

    }
    public void requestVerificationCode(int dst_id, int beverageID){

    }
    public void sendVerificationCode(String code){

    }
    public void requestRefund(){

    }
    public void requestVmOn(String address){

    }
    public void sendOperating(String address){

    }
    public void requestVmOff(){

    }
}