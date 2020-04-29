package com.xiaofei.service.impl;

import com.xiaofei.dao.MobileDao;
import com.xiaofei.entity.Mobile;
import com.xiaofei.enums.MobileBorrowStatus;
import com.xiaofei.service.MobileService;
import com.xiaofei.util.MobileResult;
import com.xiaofei.util.MobileResultUtil;
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
    public MobileResult borrowMobile(int userId, int id){
        MobileResultUtil mr = new MobileResultUtil();
        Mobile mobile = mobileDao.findById(id);
        if(mobile.getStatus() == MobileBorrowStatus.BORROWED.getCode()){
            return mr.failMsg("该手机已经借出，请确认！");
        }
        int num = mobileDao.borrowMobile(userId, id);
        if(num == 1){
            return mr.successMsg("借用手机成功！");
        }else{
            return mr.fail();
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

    @Override
    public MobileResult returnMobile(int id){
        MobileResult mr = new MobileResult();

        try {
            Mobile mobile = mobileDao.findById(id);
            if(Objects.isNull(mobile)){
                return MobileResultUtil.failMsg("该手机不存在，请确认！");
            }
            if(mobile.getStatus() == MobileBorrowStatus.UNBORROWED.getCode()){
                return MobileResultUtil.failMsg("该手机已经归还，请确认！");
            }
            int num = mobileDao.returnMobile(id);
            if(num == 1){
                mr.setMsg("归还手机成功！");
                mr.setStatus(2000);
                return mr;
            }else{
                return MobileResultUtil.fail();
            }
        }catch(Exception e){
            return MobileResultUtil.failMsg(e.getMessage());

        }


    }

}
