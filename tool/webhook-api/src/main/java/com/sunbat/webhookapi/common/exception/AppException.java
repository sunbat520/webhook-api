package com.sunbat.webhookapi.common.exception;

/**
 * @author: SunYb
 * @date: 2024/6/12 16:04
 * @version: 1.0
 */
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public AppException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AppException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public AppException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public AppException(String msg, int code, Throwable e) {
        super(msg, e);
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
