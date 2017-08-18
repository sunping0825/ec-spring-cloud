package com.ecspringcloud.easycloud.provider.user.service;

import com.ecspringcloud.easycloud.common.utils.ObjectUtil;
import com.ecspringcloud.easycloud.common.utils.SecurityUtil;
import com.ecspringcloud.easycloud.common.utils.StringUtil;
import com.ecspringcloud.easycloud.provider.user.dao.UserDao;
import com.ecspringcloud.easycloud.provider.user.entity.UserDO;
import com.ecspringcloud.easycloud.provider.user.entity.dto.LoginDTO;
import com.ecspringcloud.easycloud.provider.user.entity.dto.UserDTO;
import com.ecspringcloud.easycloud.provider.user.entity.query.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/8/15.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public UserDTO getById(Long id) {
        UserDO userDO= userDao.getById(id);
        UserDTO userDTO= ObjectUtil.copyObject(userDO,UserDTO.class);
        return userDTO;
    }

    /**
     * 保存
     * @param userDTO
     */
    public void save(UserDTO userDTO) {
        if(userDTO==null){
            return;
        }
        UserDO userDO=ObjectUtil.copyObject(userDTO,UserDO.class);
        userDO.initId();
        userDO.setPassword(SecurityUtil.md5(userDO.getPassword()));
        userDao.save(userDO);
    }

    /**
     * 更新
     * @param id
     * @param userDTO
     */
    public void update(Long id,UserDTO userDTO) {
        if(userDTO==null){
            return;
        }
        UserDO userDO=ObjectUtil.copyObject(userDTO,UserDO.class);
        userDO.setId(id);
        userDao.updateById(userDO);
    }

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    public UserDTO login(LoginDTO loginDTO) {
        if(StringUtil.isAnyBlank(loginDTO.getUserName())){
            return null;
        }
        if(StringUtil.isAnyBlank(loginDTO.getPassword())){
            return null;
        }
        UserQuery userQuery=new UserQuery();
        userQuery.setUserName(loginDTO.getUserName());
        UserDO userDO=userDao.getByUserName(userQuery);
        String md5Password= SecurityUtil.md5(loginDTO.getPassword());
        if(md5Password.equals(userDO.getPassword())){
            return ObjectUtil.copyObject(userDO,UserDTO.class);
        }
        return null;
    }
}
