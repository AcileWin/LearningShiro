package com.rengu.cc;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class LearningShiro {
    public static void main(String[] args){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentSubject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("liwei","123456");
        try {
            currentSubject.login(token);
        }catch (UnknownAccountException e){
            System.out.println("无效的用户");
            e.printStackTrace();
        }catch (IncorrectCredentialsException e){
            System.out.println("密码有错");
            e.printStackTrace();
        }catch (AuthenticationException e){
            e.printStackTrace();
        }
        System.out.println("登陆成功");
        currentSubject.logout();
        System.out.println("退出登陆成功");
    }

}
