package com.y.common.exceptionhandler;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GCC
 * 异常model
 */

@ToString
@Data
public class UnifiedExceptionReturn {
    private int code;
    private String message;
    private String status;

    public UnifiedExceptionReturn(int code, String message, String status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}


