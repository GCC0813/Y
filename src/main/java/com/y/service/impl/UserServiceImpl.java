package com.y.service.impl;

import com.y.common.CodeMsg;
import com.y.common.exceptionhandler.BizException;
import com.y.entity.User;
import com.y.entity.UserExample;
import com.y.mapper.UserMapper;
import com.y.service.UserService;
import com.y.vo.in.LoginIn;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author GCC.
 * Created on 2019/3/8.
 */
@Log4j2
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> selectById(LoginIn in) {
        List<User> userList = new ArrayList<>();
        try {
            UserExample userExample=new UserExample();
            userExample.createCriteria().andIdEqualTo(in.getId());
            userList= userMapper.selectByExample(userExample);
            if(userList.isEmpty()){
                throw new BizException(CodeMsg.CODE_1000.getCode(),CodeMsg.CODE_1000.getMsg());
            }

        }catch (BizException e){
            log.info(e);
            throw new BizException(e.getCode(),e.getMsg());
        }catch (Exception e){
            log.error(e);
            throw new BizException(CodeMsg.SYSTEM_ERROR.getCode(),CodeMsg.SYSTEM_ERROR.getMsg());
        }
        return userList;
    }

}

