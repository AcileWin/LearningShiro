package com.rengu.cc.day3.permission.shiro4INI.test;

import com.rengu.cc.day2.shiroUtill.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @Author:LiuFeng
 * @Description:shiro4.ini权限测试
 * @Date:11:04 2017/11/14
 * @ClassName:shiro1
 */
public class PermissionTest {
    @Test
    public void testIsPermitted(){
        Subject currentUser = ShiroUtil.login("shiro4.ini", "liwei", "123456");
        boolean b = currentUser.isPermitted("user:select");
        System.out.println(b);

        boolean[] results = currentUser.isPermitted("user:add", "user:update", "user:delete");
        System.out.println(results[0]);
        System.out.println(results[1]);
        System.out.println(results[2]);
//        System.out.println(results[0]);

        boolean result = currentUser.isPermittedAll("user:add", "user:update", "user:select");
        System.out.println(result);
    }

    @Test
    public void testCheckPermitted(){
        Subject currentUser = ShiroUtil.login("shiro4.ini", "zhouguang", "666666");
//        currentUser.checkPermission("user:select");
        currentUser.checkPermissions("user:delete","user:update","user:delete");
    }
}
