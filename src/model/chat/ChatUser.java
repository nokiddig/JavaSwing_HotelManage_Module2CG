package model.chat;

import view.userView.JPChatbox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatUser extends Thread{
    private Socket socket;
    private  DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private JPChatbox jpChatbox;
    public void init () {
        try {
            socket = new Socket("localhost", 3333);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String mes) {
        try {
            dataOutputStream.writeUTF(mes);
            dataOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readMessage() {
        String mes = "";
        try {
            mes = dataInputStream.readUTF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mes;
    }

    public void closePort(){
        try {
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        this.init();
        while (true) {
            jpChatbox.addMessage(readMessage());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setJpChatbox(JPChatbox jpChatbox) {
        this.jpChatbox = jpChatbox;
    }
}
