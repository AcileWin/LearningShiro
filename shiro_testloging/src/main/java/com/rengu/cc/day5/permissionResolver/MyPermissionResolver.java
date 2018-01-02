package com.rengu.cc.day5.permissionResolver;

import com.rengu.cc.day5.customPermission.MyPermission;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @Author:LiuFeng
 * @Description:告诉shiro根据字符串的表现形式采用相应permission进行匹配
 * @Date:13:33 2017/11/15
 * @ClassName:shiro1
 */
public class MyPermissionResolver implements PermissionResolver{

    /**
     * 如果我们的权限字符串是以 “+” 号开头的话，就使用我们自定义的 MyPermission ，否则就使用默认的 WildcardPermission 解析这个字符串
     * @param s 权限字符串
     * @return 权限解析方式
     */
    public Permission resolvePermission(String s) {
        if (s.startsWith("+")){
            return new MyPermission(s);
        }
        return new WildcardPermission(s);
    }
}
