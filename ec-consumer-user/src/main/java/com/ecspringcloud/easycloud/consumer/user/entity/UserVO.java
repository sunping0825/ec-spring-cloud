package com.ecspringcloud.easycloud.consumer.user.entity;

/**
 * Created by Administrator on 2017/8/15.
 */
public class UserVO {
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
