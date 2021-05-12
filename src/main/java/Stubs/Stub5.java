package Stubs;

import Logic.Msg;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Stub5 extends Thread{
    private final int SERVER_PORT_OFFSET = 9000;
    public int myID = 5;
    private int targetID;
    String myAddress = "일감호 바닥 밑";
    ServerSocket serverSocket = null;
    Socket receive_socket = null;
    Socket send_socket = null;
    Msg sendMsg = null;


    ObjectInputStream objectInputStream = null;
    ObjectOutputStream objectOutputStream = null;

    public static void main(String args[]){

        Stub5 stub = new Stub5(3);     //우리 DVM의 ID
        stub.startDVM();
        stub.run();
    }

    Stub5(int targetID){
        this.targetID = targetID;
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(SERVER_PORT_OFFSET + this.myID);
            System.out.println("Server Running");

            while (true) {
                receive_socket= serverSocket.accept();
                System.out.println("Client connected");

                objectInputStream = new ObjectInputStream(receive_socket.getInputStream());
                Msg msg = (Msg) objectInputStream.readObject();

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
                        objectOutputStream = new ObjectOutputStream(receive_socket.getOutputStream());
                        sendMsg = new Msg(myID, msg.getSrc_id(), 2, myAddress);
                        objectOutputStream.writeObject(sendMsg);
                        objectOutputStream.flush();
                        break;
                    case 3:
                        //deleteVM
                        break;
                    case 4:
                        objectOutputStream = new ObjectOutputStream(receive_socket.getOutputStream());
                        /* Stub true/false 수정 가능 */
                        sendMsg = new Msg(myID, msg.getSrc_id(), 5, Boolean.toString(true));
                        //sendMsg = new Msg(myID, msg.getSrc_id(), 5, "false");
                        objectOutputStream.writeObject(sendMsg);
                        objectOutputStream.flush();
                        break;
                    case 6:
                        //checkStockVerification()
                        /* 해당 제품의 재고가 있으면*/
                        boolean stockAvailable = true;              //Stub : 재고 여부 변경 가능
                        if (stockAvailable) {
                            objectOutputStream = new ObjectOutputStream(receive_socket.getOutputStream());
                            sendMsg = new Msg(myID, msg.getSrc_id(), 7, "1452");         //인증코드 변경 가능
                        } else {
                            objectOutputStream = new ObjectOutputStream(receive_socket.getOutputStream());
                            sendMsg = new Msg(myID, msg.getSrc_id(), 8, null);
                        }
                        objectOutputStream.writeObject(sendMsg);
                        objectOutputStream.flush();
                        break;
                }
                receive_socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startDVM(){
        try{
            Socket send_socket = new Socket("localhost", SERVER_PORT_OFFSET + 3);
            objectOutputStream = new ObjectOutputStream(send_socket.getOutputStream());
            Msg msg = new Msg(myID, 3, 1, myAddress);
            objectOutputStream.writeObject(msg);
            objectOutputStream.flush();
            System.out.println("Send Msg:"+msg.getSrc_id()+" "+msg.getDst_id()+" "+msg.getType()+" "+msg.getDescription());
            objectInputStream = new ObjectInputStream(send_socket.getInputStream());
            Msg temp = (Msg) objectInputStream.readObject();
            System.out.println("Receive Msg:"+temp.getSrc_id()+" "+temp.getDst_id()+" "+temp.getType()+" "+temp.getDescription());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}