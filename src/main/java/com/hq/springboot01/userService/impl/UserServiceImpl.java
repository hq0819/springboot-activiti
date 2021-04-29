package com.hq.springboot01.userService.impl;

import com.hq.springboot01.mapper.UserMapper;
import com.hq.springboot01.pojo.User;
import com.hq.springboot01.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUser(String username) {
        return userMapper.getUser(username);
    }
}
