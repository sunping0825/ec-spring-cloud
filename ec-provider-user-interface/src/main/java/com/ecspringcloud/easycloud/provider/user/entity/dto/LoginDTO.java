package com.ecspringcloud.easycloud.provider.user.entity.dto;

/**
 * @author sunping
 * @create 2017/8/17
 */
public class LoginDTO {
    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
