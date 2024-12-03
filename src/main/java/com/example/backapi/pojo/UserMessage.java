package com.example.backapi.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class UserMessage implements Serializable {

    private Integer mid;
    private List<MessageBean> messageList;


    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public List<MessageBean> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageBean> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "mid=" + mid +
                ", messageList=" + messageList +
                '}';
    }
}
