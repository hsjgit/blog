package com.hsj.blogwaja.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 响应给前端页面的结果
 * @author waja
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int resultCode;
    private String message;
    private T data;

    public Result() {
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

}
