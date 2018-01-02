package com.rengu.cc.day4.customRealm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author:LiuFeng
 * @Description:
 * @Date:16:02 2017/11/13
 * @ClassName:shiro1
 */
public class MyStaticRealm extends AuthorizingRealm{
    // 用于授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    // 用于认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();
        String password = new String((char[]) token.getCredentials());
        if (!"liwei".equals(userName)){
            throw new UnknownAccountException("无效的用户名www");
        }else if (!"123456".equals(password)){
            throw new IncorrectCredentialsException("密码无效");
        }
        return new SimpleAuthenticationInfo("liweipower@gmail","123456",getName());
    }
}
