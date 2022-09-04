package model.entity;

import java.util.Date;

public class Message {
    private String content = "";
    private String sender = "", receiver = "";
    private Date time = new Date();
    private String type;

    public Message(){}

    public Message(String content, String sender, String receiver, Date time) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.time = time;
    }
}
