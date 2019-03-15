package com.y.controller;

import com.y.common.CodeMsg;
import com.y.common.exceptionhandler.BizException;
import com.y.entity.User;
import com.y.service.UserService;
import com.y.vo.JsonOut;
import com.y.vo.in.LoginIn;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
@RestController
@RequestMapping("/v1/login")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public JsonOut login(@RequestBody @Validated LoginIn in) {
        JsonOut<List<User>> jsonOut = new JsonOut<>();
        try {
            jsonOut.setData(userService.selectById(in));
        }catch (BizException e){
            log.info("");
            return new JsonOut(e.getCode(),e.getMsg());
        }
        return jsonOut;
    }
}
