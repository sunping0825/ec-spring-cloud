package com.ecspringcloud.easycloud.common.utils;

import org.springframework.beans.BeanUtils;

/**
 * Created by Administrator on 2017/8/15.
 */
public class ObjectUtil {
    /**
     * 拷贝对象
     * @param source
     * @param copyTo
     * @param <T>
     * @return
     */
    public static <T> T copyObject(Object source, Class<T> copyTo){
        if(source==null){
            return null;
        }
        T t=BeanUtils.instantiate(copyTo);
        BeanUtils.copyProperties(source,t);
        return t;
    }
}
