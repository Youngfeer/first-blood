package com.xiaofei.service;

import com.xiaofei.entity.Mobile;
import com.xiaofei.entity.User;
import com.xiaofei.util.MobileResult;

import java.util.List;

/**
 * Created by yangrao on 2020/4/2.
 */
public interface MobileService {

    public List<Mobile> getAllMobile();
    public boolean addMobile(Mobile mobile);
    public MobileResult borrowMobile(int userId, int id);
    public Mobile findById(int id);
    public MobileResult returnMobile(int id);
}
