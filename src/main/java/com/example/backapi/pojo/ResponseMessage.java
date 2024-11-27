package com.example.backapi.pojo;

import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

public class ResponseMessage<T> {

    private Integer code;  //200 400
    private String message; //返回的信息
    private  T data;

    public  static  <T> ResponseMessage success(T data){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(HttpStatus.OK.value());
        responseMessage.setMessage("成功");
        responseMessage.setData(data);
        return  responseMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
