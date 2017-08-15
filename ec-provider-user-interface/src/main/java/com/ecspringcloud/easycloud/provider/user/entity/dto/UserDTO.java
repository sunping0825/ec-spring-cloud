package com.ecspringcloud.easycloud.provider.user.entity.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/8.
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
