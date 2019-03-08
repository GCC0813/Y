package com.y.controller;

import com.y.common.exceptionHandler.BizException;
import com.y.entity.User;
import com.y.entity.UserExample;
import com.y.service.UserService;
import com.y.vo.JsonOut;
import com.y.vo.in.LoginIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GCC.
 * Created on 2019/3/5.
 */
@RestController
@RequestMapping("/v1/login")
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public JsonOut login(@RequestBody @Validated LoginIn in) {
        try {
            UserExample userExample=new UserExample();
            return  new JsonOut<>(200,in.getUserName(),userService.selectById(userExample));
        }catch (BizException e){
            return new JsonOut(e.getCode(),e.getMsg());
        }
    }
}
