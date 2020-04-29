package com.xiaofei.shiro;

import com.xiaofei.entity.User;
import com.xiaofei.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yangrao on 2020/4/28.
 */
public class MyShiroRealm extends AuthorizingRealm {
    Boolean cachingEnabled=true;
    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {

       return null;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获得当前用户的用户名
        String username = (String) authenticationToken.getPrincipal();

        //从数据库中根据用户名查找用户
        User user = userService.findUserByName(username);
        if (userService.findUserByName(username) == null) {
            throw new UnknownAccountException(
                    "没有在本系统中找到对应的用户信息。");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return info;
    }


}
