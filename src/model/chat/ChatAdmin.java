package model.chat;

import view.adminManager.JPInformation;
import view.userView.JPChatbox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatAdmin extends Thread{
    private ServerSocket serverSocket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;
    private JPInformation jpInformation;

    public void init() {
        try{
            serverSocket = new ServerSocket(3333);
            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e) {
            e.printStackTrace();
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
        String mes;
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
            serverSocket.close();
            socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        System.out.println("thread is running...");
        this.init();
        while (true) {
            this.jpInformation.getJtaNoti().setText(readMessage() + "\n");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setJpInformation(JPInformation jpInformation) {
        this.jpInformation = jpInformation;
    }
}