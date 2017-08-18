package com.ecspringcloud.easycloud.provider.user.dao;


import com.ecspringcloud.easycloud.provider.user.entity.UserDO;
import com.ecspringcloud.easycloud.provider.user.entity.query.UserQuery;

/**
 * Created by Administrator on 2017/8/8.
 */
public interface UserDao {
    /**
     * 保存用户
     * @param user
     * @return
     */
    int save(UserDO user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateById(UserDO user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    UserDO getById(Long id);

    /**
     * 根据名称获取
     * @param userQuery
     * @return
     */
    UserDO getByUserName(UserQuery userQuery);
}
