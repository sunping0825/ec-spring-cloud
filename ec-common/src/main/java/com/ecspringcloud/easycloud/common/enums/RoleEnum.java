package com.ecspringcloud.easycloud.common.enums;

/**
 * @author sunping
 * @create 2017/8/17
 */
public enum  RoleEnum {
    PLAT_ADMIN(0, "成功");
    private Integer value;
    private String name;

    private RoleEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
