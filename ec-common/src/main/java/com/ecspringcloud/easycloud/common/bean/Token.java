package com.ecspringcloud.easycloud.common.bean;

import com.ecspringcloud.easycloud.common.enums.RoleEnum;

import java.util.List;

/**
 * @author sunping
 * @create 2017/8/17
 */
public class Token {
    private Long userId;
    private String name;
    private String token;
    private List<Permission> permissionList;
    private List<RoleEnum> roleList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<RoleEnum> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleEnum> roleList) {
        this.roleList = roleList;
    }
}
