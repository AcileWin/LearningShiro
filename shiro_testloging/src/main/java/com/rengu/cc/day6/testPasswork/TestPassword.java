package com.rengu.cc.day6.testPasswork;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;

/**
 * @Author:LiuFeng
 * @Description:验证密码密文
 * @Date:14:41 2018/1/2
 * @ClassName:shiro1
 */
public class TestPassword {
    public static void main(String[] args) {
        PasswordService service = new DefaultPasswordService();
        String str1 = service.encryptPassword("123456");
        String str2 = service.encryptPassword("123456");
        System.out.println("str1:"+str1);
        System.out.println("str2:"+str2);
        boolean b1 = service.passwordsMatch("123456",str1);
        boolean b2 = service.passwordsMatch("123456",str2);
        System.out.println("b1:"+b1);
        System.out.println("b2:"+b2);
    }
}
