package com.nvclouds.medusaskadicommon.base;

import java.util.HashMap;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/3/3 10:53
 * @Description:
 */
public class BaseResult<T> {

    private int code;
    private String msg;
    private T data;

    public BaseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static <T> BaseResult<T> error(String msg) {
        return new BaseResult<>(1000, msg, null);
    }

    public static <T> BaseResult<T> error(int code, String msg) {
        return new BaseResult<>(code, msg, null);
    }

    public static <T> BaseResult<T> error(int code, String msg,T data) {
        return new BaseResult<>(code, msg, data);
    }

    public static <T> BaseResult.Builder<T> builder() {
        return new BaseResult.Builder();
    }

    public static <T> BaseResult<T> ok() {
        return (new BaseResult.Builder()).build();
    }

    public static <T> BaseResult<T> ok(T data) {
        return (new BaseResult.Builder()).data(data).build();
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean success() {
        return this.code == 0;
    }

    public boolean error() {
        return !this.success();
    }

    public static class Builder<T> {
        BaseResult<T> result = new BaseResult(0, "", new HashMap());

        public Builder() {
        }

        public BaseResult.Builder<T> code(int code) {
            this.result.code = code;
            return this;
        }

        public BaseResult.Builder<T> msg(String msg) {
            this.result.msg = msg;
            return this;
        }

        public BaseResult.Builder<T> data(T data) {
            this.result.data = data;
            return this;
        }

        public BaseResult<T> build() {
            return this.result;
        }
    }
}
