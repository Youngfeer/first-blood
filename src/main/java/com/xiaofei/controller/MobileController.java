package com.xiaofei.controller;

import com.xiaofei.entity.Mobile;
import com.xiaofei.service.MobileService;
import com.xiaofei.util.MobileResult;
import com.xiaofei.util.MobileResultUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yangrao on 2020/4/2.
 */
@RestController
public class MobileController {
    @Autowired
    private MobileService mobileService;

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @RequestMapping("mobile")
    public MobileResult<List<Mobile>> morning(){
        System.out.println("come in");
        MobileResult mr = new MobileResult();
        List<Mobile> list = mobileService.getAllMobile();
        logger.info("start get mobile");
        mr.setData(list);
        mr.setStatus(200);
        mr.setMsg("success");
        return mr;
    }

    @PostMapping("borrow")
    public  MobileResult borrowMobile(@RequestParam(value = "userId") int userId, @RequestParam(value = "id") int id){
        return mobileService.borrowMobile(userId, id);

    }

    @PostMapping("add")
    public  MobileResult addMobile(@RequestBody Mobile mobile){
        MobileResult mr = new MobileResult();
        boolean addM = mobileService.addMobile(mobile);
        if(addM){
            mr.setStatus(2000);
            mr.setMsg("success");
            mr.setData(addM);

        }else{
            mr.setData(null);
            mr.setMsg("fail");
            mr.setStatus(50000);
        }
        return mr;

    }

    @PostMapping("return")
    public MobileResult returnMobile(@RequestParam(value = "id") int id){

        return mobileService.returnMobile(id);
    }

}
