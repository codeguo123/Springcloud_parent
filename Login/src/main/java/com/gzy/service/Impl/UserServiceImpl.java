package com.gzy.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzy.damain.User;
import com.gzy.dao.UserMapper;
import com.gzy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMaper;


    public int addUser(User user) {
        return	userMaper.addUser(user);
    }

    public int findUserByNameAndPassWord(String username, String password) {
        return userMaper.findUserByNameAndPassWord(username, password);
    }

    public int findUserByName(String username) {
        return userMaper.findUserByName(username);
    }
}