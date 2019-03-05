package com.y.vo;

import lombok.Data;

/**
 * @author GCC.
 * Created on 2019/3/4.
 */
@Data
public class JsonOut<T> {
    private int code;
    private String message;
    private T data;

    public JsonOut(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonOut(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


}
