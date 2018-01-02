package com.rengu.cc.day5.customPermission;

import org.apache.shiro.authz.Permission;

/**
 * @Author:LiuFeng
 * @Description:自定义权限
 * @Date:9:59 2017/11/15
 * @ClassName:shiro1
 */
public class MyPermission implements Permission{
    private String resourceId;
    private String operator;
    private String instanceId;

    public MyPermission(){}

    public MyPermission(String permissionStr){
        String[] strs = permissionStr.split("\\+");
        if (strs.length>1){
            this.resourceId=strs[1];
        }
        if (this.resourceId == null || "".equals(this.resourceId)){
            this.resourceId = "*";
        }
        if (strs.length>2){
            this.resourceId=strs[2];
        }
        if (strs.length>3){
            this.resourceId=strs[3];
        }
        if (this.resourceId == null || "".equals(this.resourceId)){
            this.resourceId = "*";
        }
        System.out.println("实例化MyPermission时 =>"+this.toString());
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof MyPermission)){
            return false;
        }
        MyPermission mp = (MyPermission) permission;
        if ((!"*".equals(mp.resourceId)) && !this.resourceId.equals(mp.resourceId)){
            return false;
        }
        if ((!"*".equals(mp.operator)) && !this.operator.equals(mp.operator)){
            return false;
        }
        if ((!"*".equals(mp.instanceId)) && !this.instanceId.equals(mp.instanceId)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyPermission{" +
                "resourceId='" + resourceId + '\'' +
                ", operator='" + operator + '\'' +
                ", instanceId='" + instanceId + '\'' +
                '}';
    }
}
