package com.ecspringcloud.easycloud.provider.user.entity;



/**
 * Created by Administrator on 2017/8/8.
 */
public class UserDO extends BaseDO {
    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

