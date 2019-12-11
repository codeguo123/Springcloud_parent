package com.gzy.fegin;

import com.gzy.damain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="serviceLogin")
public interface FeginService {
    // 测试注册账号可以使用
    @RequestMapping(value="register",method=RequestMethod.POST)
    public int userNameTestFegin(@RequestParam("username") String username);

    // 登陆测试
    @RequestMapping(value="loginGzy",method=RequestMethod.POST)
    public int LoginFegin(@RequestParam("username") String username, @RequestParam("password") String password);

    //注册账号
    @RequestMapping(value="insert",method=RequestMethod.POST)
    public int registerUserFegin(@RequestBody User user);
}
