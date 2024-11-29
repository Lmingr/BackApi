package com.example.backapi.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class UserMessage implements Serializable {

    private String username;
    private List<MessageBean> message;


    public UserMessage(String username, List<MessageBean> message) {
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public List<MessageBean> getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserMessage that)) return false;
        return Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getMessage());
    }


    @Override
    public String toString() {
        return "UserMessage{" +
                "username='" + username + '\'' +
                ", message=" + message +
                '}';
    }
}
