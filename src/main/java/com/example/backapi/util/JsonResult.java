package com.example.backapi.util;


import java.io.Serializable;

/**
 * 创建响应
 * 以Json格式的数据进行响应，包括状态码，详细信息，数据
 */
public class JsonResult<E> implements Serializable {

    /** 状态码*/
    private  Integer state;

    /** 描述信息 */
    private  String message;

    /** 数据 */
    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
		this.state = state;
	}


	public JsonResult(Integer state, String message) {
		this.state = state;
		this.message = message;
	}

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(Integer state, String message, E data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public JsonResult(Throwable e) {
    	this.message = e.getMessage();
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
