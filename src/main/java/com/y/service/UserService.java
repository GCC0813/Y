package com.y.service;

import com.y.entity.Abc;
import com.y.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GCC.
 * Created on 2019/3/7.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public int abc(){
        Abc abc=new Abc();
        return abc.getI();
    }
}
