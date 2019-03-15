package com.y.common.exceptionhandler;



import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author GCC
 * 全局异常处理
 */
@RestControllerAdvice
public class RestExceptionHandler {

   /**
     * 系统异常处理，比如：404,500
     * @param req
     * @param e
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public UnifiedExceptionReturn defaultErrorHandler(HttpServletRequest req, HttpServletResponse res , Exception e ) {

        if (e instanceof NoHandlerFoundException) {
            return new UnifiedExceptionReturn(404,"请求无响应。","｡◕_◕｡");
        }
        if(e instanceof MethodArgumentNotValidException){
            return new UnifiedExceptionReturn(300,((MethodArgumentNotValidException) e).getBindingResult().getFieldError().getDefaultMessage(),"｡◕_◕｡");
        }
        return new UnifiedExceptionReturn(500,"网络开小差了。","｡◕_◕｡");
    }


}

