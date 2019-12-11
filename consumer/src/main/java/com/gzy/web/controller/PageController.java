package com.gzy.web.controller;

import com.gzy.damain.User;
import com.gzy.fegin.FeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class PageController {
    @Autowired
    private FeginService feginService;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /*
     * 注册账号
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String registerUser(User user) {

        int count = feginService.registerUserFegin(user);

        if (count > 0) {
            return "login";
        } else {
            return "register";
        }
    }

    // 登陆测试
    @RequestMapping(value = "/loginGzy", method = RequestMethod.POST)
    @ResponseBody
    public int Login(@RequestParam("username") String username, @RequestParam("password") String password) {

        int result;
        /*通过这个feginService把数据传到服务提供者--->然后由服务提供者从数据库得到的数据返回到服务消费者这边*/
        int count = feginService.LoginFegin (username, password);
        System.out.println("===================================="+username+password);
        if (username == null || username == "" || password == "" || password == null) {
           //账户0r密码不能为空
           // System.out.println("请注册");
            result = 2;
        } else if (count > 0) {
            //可以使用
            result = 3;
        } else {
            //账号已经被组册
            result = 1;
        }
        return result;
    }
}