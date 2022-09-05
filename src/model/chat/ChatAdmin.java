package model.chat;

import view.adminManager.JPInformation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatAdmin extends Thread{
    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private JPInformation jpInformation;

    public void init() {
        try{
            serverSocket = new ServerSocket(3333);
            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e) {
            System.out.println("Socket ngu 1");
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
            if (dataOutputStream!=null)
                dataOutputStream.close();
            if (dataInputStream!=null)
                dataInputStream.close();
            if (serverSocket!=null)
                serverSocket.close();
            if (socket!=null)
                socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        this.init();
        while (true) {
            if (socket==null || socket.isClosed()) {
                break;
            }
            jpInformation.addMessage(readMessage());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("socket ngu");
            }
        }
    }
    public void setJpInformation(JPInformation jpInformation) {
        this.jpInformation = jpInformation;
    }
}