package com.xp.rxjavaretrofit.model;

import java.io.Serializable;

/**
 * @author: xp
 * @date: 2017/4/26
 */

public class BaseEntity<T> implements Serializable {

    private int status_code;
    private String error_msg;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
