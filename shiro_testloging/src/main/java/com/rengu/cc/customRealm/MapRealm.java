package com.rengu.cc.customRealm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:LiuFeng
 * @Description:自定义Realm
 * @Date:10:15 2017/11/13
 * @ClassName:shiro1
 */
public class MapRealm implements Realm{
    private static Map<String,String> users;
    static {
        users = new HashMap<String, String>();
        users.put("liwei","123456");
        users.put("zhouguang","666666");
    }

    /**
     * 返回唯一的Realm名字
     *
     * @return Realm实现类名称
     */
    public String getName() {
        return "MyStaticRealm";
    }

    /**
     * 判断此Realm是否支持此token
     * @param authenticationToken token参数
     * @return boolen值
     */
    public boolean supports(AuthenticationToken authenticationToken) {
        // 仅支持UsernamePasswordToken类的token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    /**
     * 根据token获取认证信息
     * @param authenticationToken token参数
     * @return
     * @throws AuthenticationException
     */
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if (!users.containsKey(userName)) {
            throw new UnknownAccountException("无此用户");
        }else if (!password.equals(users.get(userName))){
            throw new IncorrectCredentialsException("密码错误");
        }
        return new SimpleAuthenticationInfo(userName,password,getName());
    }
}
