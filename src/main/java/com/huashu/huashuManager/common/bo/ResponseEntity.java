package com.huashu.huashuManager.common.bo;

import java.io.Serializable;

public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = -2245460634203751588L;
    /**
     * 200表示操作成功
     */
    private int code;

    /**
     * 返回数据包
     */
    private T data;

    /**
     * 异常信息
     */
    private String msg;

    public ResponseEntity(Builder<T> builder) {
        this.code = builder.code;
        this.data = builder.data;
        this.msg = builder.msg;
    }

    public int getCode() {
        return code;
    }

    public ResponseEntity<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseEntity<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseEntity<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public static class Builder<T> {
        private int code = 200;

        private T data;

        private String msg;

        public Builder<T> setCode(int code) {
            this.code = code;
            return this;
        }

        public Builder<T> setData(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public ResponseEntity<T> build(){
            return new ResponseEntity<>(this);
        }
    }
}
