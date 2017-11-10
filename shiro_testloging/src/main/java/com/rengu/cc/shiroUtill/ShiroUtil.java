package com.rengu.cc.shiroUtill;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
/**
 * @Author:LiuFeng
 * @Description: 添加shiro工具类shiroUtil实现用户登陆
 * @Date 10:57 2017/11/10
 * @param: No such property: _1 for class: Script1
 */
public class ShiroUtil {
    /**
     * @Author:LiuFeng
     * @Description:编写shiro登陆的方法
     * @Date 20:52 2017/11/9
     * @param:configFileName 文件名
     * @param:userName 用户名
     * @param:password 密码
     */
    public static Subject login(String configFileName,String userName,String password){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:"+configFileName);
        SecurityManager securityManager = factory.getInstance();
        // 把securityManager的实例绑定到SecurityUtils上
        SecurityUtils.setSecurityManager(securityManager);
        // 获取当前执行的用户
        Subject currentUser = SecurityUtils.getSubject();
        // 创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            currentUser.login(token);
            System.out.println("登陆成功");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("无效的用户名");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("错误的密码");
        }catch (AuthenticationException e){
            e.printStackTrace();
        }
        return currentUser;
    }
}
