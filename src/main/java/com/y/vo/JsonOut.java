package com.y.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author GCC.
 * Created on 2019/3/4.
 */
@Data
public class JsonOut<T> {
    private int code = 200;
    private String message = "成功";
    private T data;

    public JsonOut() {
    }

    public JsonOut(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public T getData() {
        if (data == null) {
            if (this.getCode() == 200) {
                return (T) "｡◕‿◕｡";
            } else {
                return (T) "｡◕︵◕｡";
            }
            //return (T) new HashMap<>();
        }
        return data;
    }

   public String getMessage() {
        if (data != null) {
            return "｡◕‿◕｡";
        }
        return message;
    }
}