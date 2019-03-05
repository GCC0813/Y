package com.y.controller;

import com.y.common.exceptionHandler.BizException;
import com.y.vo.JsonOut;
import com.y.vo.in.LoginIn;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GCC.
 * Created on 2019/3/5.
 */
@RestController
@RequestMapping("/v1/login")
public class LoginController {

    @PostMapping("/login")
    public JsonOut login(@RequestBody @Validated LoginIn in) {
        try {
            return  new JsonOut<>(200,"成功",in);
        }catch (BizException e){
            return new JsonOut(e.getCode(),e.getMsg());
        }
    }
}
