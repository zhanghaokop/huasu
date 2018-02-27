package com.huashu.huashuManager.common.bo;

public class ResponseEntity<T> {

    private int code;

    private T data;

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
        private int code;

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
