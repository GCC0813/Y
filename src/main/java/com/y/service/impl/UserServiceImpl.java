package com.y.service.impl;

import com.y.entity.User;
import com.y.entity.UserExample;
import com.y.mapper.UserMapper;
import com.y.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GCC.
 * Created on 2019/3/8.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> selectById(UserExample user) {
        return userMapper.selectByExample(user);
    }
}
