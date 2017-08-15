package com.ecspringcloud.easycloud.common.enums;

/**
 * Created by Administrator on 2017/8/15.
 */
public enum ResultEnum {
    SUCCESS(0, "成功");
    private Integer value;
    private String name;

    private ResultEnum(Integer value, String name) {
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
