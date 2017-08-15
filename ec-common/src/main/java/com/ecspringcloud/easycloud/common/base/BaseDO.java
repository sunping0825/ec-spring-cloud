package com.ecspringcloud.easycloud.common.base;

import com.ecspringcloud.easycloud.common.utils.SnowflakeIdWorker;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/15.
 */
public class BaseDO {
    private Long id;
    private Date createDate;
    private Date updateDate;

    public void initId(){
        if(this.id==null){
            this.id= SnowflakeIdWorker.getNextId();
        }
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
