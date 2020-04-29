package com.xiaofei.controller;

import com.xiaofei.entity.User;
import com.xiaofei.service.UserService;
import com.xiaofei.util.MobileResult;
import com.xiaofei.util.MobileResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangrao on 2020/4/27.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public MobileResult Login(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(usernamePasswordToken);

            return MobileResultUtil.successMsg("登录成功！");

        }catch (AuthenticationException e) {
            return MobileResultUtil.failMsg("用户名或者密码错误！");
        }

    }

    @PostMapping("/register")
    public MobileResult Register(@RequestBody User user){
        return userService.addUser(user);
    }
}
