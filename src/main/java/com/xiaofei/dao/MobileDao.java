package com.xiaofei.dao;

import com.xiaofei.entity.Mobile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangrao on 2020/3/25.
 */
@Mapper
public interface MobileDao {
    public Mobile findById(int id);
    public List<Mobile> getAllMobile();
    public boolean addMobile(Mobile mobile);
    public boolean borrowMobile(@Param(value = "userId") int userId, @Param(value = "id")int id);
}
