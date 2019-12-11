package com.gzy.service;


import org.springframework.stereotype.Component;

import com.gzy.damain.User;
@Component
public interface UserService {
    //用来注册账号
    int addUser(User user);
    //用来登陆验证账号
    int findUserByNameAndPassWord(String username ,String password);
    //在注册的时候用来验证账号是否重复
    int findUserByName(String username);

}
