package com.example.backapi.pojo;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ChatMessage implements Serializable {

    private Integer mid;
    private String username;
    private String messageTopic;
    private String messageContent;
    private Date messageDate;
    private List<MessageBean> messageList;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageTopic() {
        return messageTopic;
    }

    public void setMessageTopic(String messageTopic) {
        this.messageTopic = messageTopic;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public List<MessageBean> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageBean> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "mid=" + mid +
                ", username='" + username + '\'' +
                ", messageTopic='" + messageTopic + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageDate=" + messageDate +
                ", messageList=" + messageList +
                '}';
    }
}
