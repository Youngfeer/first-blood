package com.xiaofei.service.impl;

import com.xiaofei.dao.UserDao;
import com.xiaofei.entity.User;
import com.xiaofei.service.FirstNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangrao on 2020/3/14.
 */
@Service
public class FirstNameServiceImpl implements FirstNameService{

    @Autowired
    public UserDao userDao;

    @Override
    public String sayHello(String name) {
        User user = userDao.findByName(name);
        if(user == null){
            return "请检查用户名是否正确";
        }else{
            return user.getUsername().toString();
        }



    }
}
