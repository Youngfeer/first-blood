package com.xiaofei.service.impl;

import com.xiaofei.dao.UserDao;
import com.xiaofei.entity.User;
import com.xiaofei.service.UserService;
import com.xiaofei.util.MobileResult;
import com.xiaofei.util.MobileResultUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by yangrao on 2020/4/27.
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public MobileResult login(User user) {
        try {
            User mem = userDao.findByName(user.getUsername());
            if(Objects.isNull(mem)){
                return MobileResultUtil.failMsg("用户名或者密码不对！");
            }else if(user.getPassword().equals(mem.getPassword()) && user.getUsername().equals(mem.getUsername())){
                return MobileResultUtil.successMsg("登录成功！");
            }
            return MobileResultUtil.failMsg("用户名或者密码不对！");
        }catch(Exception e){
            return MobileResultUtil.failMsg(e.getMessage());
        }
    }

    @Override
    public User findUserByName(String name){
        try {
            User user = userDao.findByName(name);
            if(Objects.nonNull(user)){
                return user;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }

    }
    @Override
    public MobileResult addUser(User user){
        MobileResult mr = new MobileResult();
        if(Objects.nonNull(userDao.findByName(user.getUsername()))){
            return MobileResultUtil.failMsg("该用户名已存在！");
        }
        Map<String, String> encrypt = encryption(user.getPassword());
        user.setPassword(encrypt.get("password"));
        user.setSalt(encrypt.get("salt"));
        try {
           boolean addFalg = userDao.addUser(user);
           if(addFalg){
               mr.setMsg("用户注册成功！");
               mr.setStatus(2000);
               mr.setData(user);
               return mr;
           }
           return MobileResultUtil.failMsg("用户注册失败！");
        }catch(Exception e){
            return MobileResultUtil.failMsg(e.getMessage());
        }
    }

    public Map<String, String> encryption(String pwd){
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        String password = new Md5Hash(pwd, salt, 2).toString();
        Map<String, String> map = new HashMap<String, String>();
        map.put("salt", salt);
        map.put("password", password);
        return map;
    }
}
