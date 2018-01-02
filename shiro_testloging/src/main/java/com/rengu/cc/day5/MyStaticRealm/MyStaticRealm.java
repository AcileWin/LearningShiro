package com.rengu.cc.day5.MyStaticRealm;

import com.rengu.cc.day5.customPermission.MyPermission;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author:LiuFeng
 * @Description:实现授权操作
 * @Date:13:41 2017/11/15
 * @ClassName:shiro1
 */
public class MyStaticRealm extends AuthorizingRealm{

    /**
     * 用于授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("static Realm 中授权方法");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("r1");
        info.addRole("r2");
        info.addStringPermission("+user+");
        info.addObjectPermission(new MyPermission("+user+add+1"));
        return info;
    }

    /**
     * 用于认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
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
