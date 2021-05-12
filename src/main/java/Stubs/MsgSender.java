package Stubs;

import Logic.Msg;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MsgSender {
    public static void main(String[] args){
        MsgSender msgSender = new MsgSender();
        while(true) {
            System.out.println("메시지를 입력하세요.");
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            String[] split = str.split("\\s+");
            msgSender.sendMsg(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]);
            if(split[3] == null){
                break;
            }
        }
    }

    public void sendMsg(int src_id, int dst_id, int type, String desc){
        Msg msg = new Msg(src_id, dst_id, type, desc);
        try{
            Socket socket = new Socket("localhost", 9003);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(msg);
            objectOutputStream.flush();
            System.out.println("Send Msg:"+msg.getSrc_id()+" "+msg.getDst_id()+" "+msg.getType()+" "+msg.getDescription());

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Msg temp = (Msg)objectInputStream.readObject();
            System.out.println("Receive Msg:"+temp.getSrc_id()+" "+temp.getDst_id()+" "+temp.getType()+" "+temp.getDescription());
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
