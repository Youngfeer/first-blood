package com.xiaofei.dao;

import com.xiaofei.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by yangrao on 2020/3/14.
 */
@Mapper
public interface UserDao {
    public User findByName(String userName);
    public boolean addUser(User user);
}
