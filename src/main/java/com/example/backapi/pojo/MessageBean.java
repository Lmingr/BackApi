package com.example.backapi.pojo;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class MessageBean implements Serializable {


    private  String topic;
    private  String content;
    private  Data  messageTime;


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Data getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Data messageTime) {
        this.messageTime = messageTime;
    }

    public MessageBean(String topic, String content) {
        this.topic = topic;
        this.content = content;
    }

    @Override
    public String toString() {
        return "messageBean{" +
                "topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }
}
