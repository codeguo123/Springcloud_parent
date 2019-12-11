package com.gzy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzy.damain.User;
import com.gzy.service.UserService;

@RestController
public class Logincontroller {

    @Autowired
    private UserService userService;
    /*
     *
     * 注册账号
     *
     */
    @RequestMapping(value="/insert",method=RequestMethod.POST)

    public int insertUser(@RequestBody User user) {
        int count =userService.addUser(user);
        System.out.println(count+"++++++++");
        System.out.println(user.getUsername()+"***"+user.getPassword()+"***"+user.getGender());
        return count;
    }

    //登陆测试
    @RequestMapping(value="/loginGzy",method=RequestMethod.POST)
    public int   login(String username,String password){
        int count =	userService.findUserByNameAndPassWord(username, password);
        return  count;
    }

    //测试注册账号可以使用
    @RequestMapping(value="/register", method=RequestMethod.POST )
    public int    userNameTest(String username) {
        System.out.println(username);
        int count= userService.findUserByName(username);
        System.out.println(count+"-----------------------------");
        return  count;
    }
}