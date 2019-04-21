package com.example.robostudent.netball;

public class ChatMesage {
    private String messageText;
    private String messageUser;

    public ChatMesage(String messageUser, String messageText){
        this.messageText = messageText;
        this.messageUser = messageUser;
    }

    public ChatMesage(){}

    public void setMessageText(String messageText) {this.messageText = messageText;}

    public String getMessageText() {return messageText;}

    public void setMessageUser(String messageUser) {this.messageText = messageUser;}

    public String getMessageUser() {return messageUser;}

}
