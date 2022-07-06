package com.start.common.pojo.requestResult;

public class MessageJson {
    Integer code; // 默认20000表示成功
    String message;

    public MessageJson(Integer code, String message) {
        this.code = code;
        this.message = message;
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
}
