package model.chat;

import view.user.ChatboxPanel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatUser extends Thread{
    private Socket socket;
    private ChatboxPanel chatboxPanel;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private boolean run;

    public void init () {
        try {
            socket = new Socket("localhost", 3333);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Cant connect to sever.");
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
            if(dataOutputStream!=null){
                mes = dataInputStream.readUTF();
            }
        } catch (IOException e) {
            return " ";
        }
        return mes;
    }

    public void closePort(){
        try {
            if (dataOutputStream!=null)
                dataOutputStream.close();
            if (dataInputStream!=null)
                dataInputStream.close();
            if (socket!=null)
                socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        this.init();
        run = true;
        while (run) {
            chatboxPanel.addMessage(readMessage());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public void setJpChatbox(ChatboxPanel chatboxPanel) {
        this.chatboxPanel = chatboxPanel;
    }
}
