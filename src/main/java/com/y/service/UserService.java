package com.y.service;

import com.y.entity.User;
import com.y.entity.UserExample;

import java.util.List;

/**
 * @author GCC.
 * Created on 2019/3/8.
 */
public interface UserService {
    List<User> selectById(UserExample user);
}
