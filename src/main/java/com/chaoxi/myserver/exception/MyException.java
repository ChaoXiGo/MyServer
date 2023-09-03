package com.chaoxi.myserver.exception;

public class MyException extends RuntimeException{
    private static final long serialVersionUID = 1;
    private String msg;
    private int code;
    public MyException(String message){
        this.code = 500;
        this.msg = message;
    }

    public MyException(String message,Throwable throwable){
        super(message,throwable);
        this.code = 500;
        this.msg = message;
    }

    public MyException(String msg, int code) {
        this.code = 500;
        this.msg = msg;
        this.code = code;
    }
    public MyException(String msg, int code,Throwable throwable) {
        super(msg,throwable);
        this.code = 500;
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
