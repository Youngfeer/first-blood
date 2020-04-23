package com.xiaofei.service.impl;

import com.xiaofei.dao.MobileDao;
import com.xiaofei.entity.Mobile;
import com.xiaofei.service.MobileService;
import com.xiaofei.util.MobileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by yangrao on 2020/4/2.
 */
@Service
public class MobileServiceImpl implements MobileService{

    @Autowired
    private MobileDao mobileDao;

    @Override
    public List<Mobile> getAllMobile() {

        List<Mobile> list = mobileDao.getAllMobile();
        if(list.isEmpty()){
            return null;
        }else{
            return list;
        }

    }
    @Override
    public boolean addMobile(Mobile mobile){

        boolean addFlag = mobileDao.addMobile(mobile);
        if(addFlag){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean borrowMobile(int userId, int id){

        boolean borrowFlag = mobileDao.borrowMobile(userId, id);
        if(borrowFlag){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Mobile findById(int id){

        Mobile mobile = mobileDao.findById(id);
        if(Objects.nonNull(mobile)){
            return mobile;
        }else{
            return null;
        }
    }

}
