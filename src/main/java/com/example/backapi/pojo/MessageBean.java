package com.example.backapi.pojo;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class MessageBean implements Serializable {

    private  String role;
    private  String content;

    public MessageBean(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
