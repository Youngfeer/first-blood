package com.xiaofei.util;

/**
 * Created by yangrao on 2020/4/23.
 */
public class MobileResultUtil {

    public static MobileResult success(Object obj){
        MobileResult mobileResult = new MobileResult();
        mobileResult.setStatus(ResultEnum.Success.getCode());
        mobileResult.setMsg(ResultEnum.Success.getMessage());
        mobileResult.setData(obj);
        return mobileResult;

    }

    public static MobileResult fail(){
        MobileResult mobileResult = new MobileResult();
        mobileResult.setStatus(ResultEnum.Fail.getCode());
        mobileResult.setMsg(ResultEnum.Fail.getMessage());
        return mobileResult;

    }
}
