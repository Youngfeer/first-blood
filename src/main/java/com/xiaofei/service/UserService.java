package com.xiaofei.service;

import com.xiaofei.entity.User;
import com.xiaofei.util.MobileResult;

/**
 * Created by yangrao on 2020/4/27.
 */
public interface UserService {
    public MobileResult login(User user);
    public User findUserByName(String name);
    public MobileResult addUser(User user);
}
