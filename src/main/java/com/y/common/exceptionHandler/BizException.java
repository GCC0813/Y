package com.y.common.exceptionHandler;

import com.y.common.CodeMsg;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

/**
 * @author GCC
 * 业务异常定义
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {

    private Integer code;
    private String msg;
    private Object data;


    public BizException(Integer code, String msg, Object data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public BizException(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(new HashMap<>(1));
    }

    public BizException() {
        this.setCode(500);
        this.setMsg("业务报错!");
    }
}
