package com.ecspringcloud.easycloud.provider.user.service;

import com.ecspringcloud.easycloud.common.utils.ObjectUtil;
import com.ecspringcloud.easycloud.provider.user.dao.UserDao;
import com.ecspringcloud.easycloud.provider.user.entity.UserDO;
import com.ecspringcloud.easycloud.provider.user.entity.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/15.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserDTO getById(Long id) {
        UserDO userDO= userDao.getById(id);
        UserDTO userDTO= ObjectUtil.copyObject(userDO,UserDTO.class);
        return userDTO;
    }

    public void save(UserDTO userDTO) {
        if(userDTO==null){
            return;
        }
        UserDO userDO=ObjectUtil.copyObject(userDTO,UserDO.class);
        userDO.initId();
        userDao.save(userDO);
    }

    public void update(Long id,UserDTO userDTO) {
        if(userDTO==null){
            return;
        }
        UserDO userDO=ObjectUtil.copyObject(userDTO,UserDO.class);
        userDO.setId(id);
        userDao.updateById(userDO);
    }
}
