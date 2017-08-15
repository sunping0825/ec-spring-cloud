package com.ecspringcloud.easycloud.consumer.user.controller;

import com.ecspringcloud.easycloud.common.base.ApiResult;
import com.ecspringcloud.easycloud.common.base.BaseController;
import com.ecspringcloud.easycloud.common.enums.ResultEnum;
import com.ecspringcloud.easycloud.consumer.user.entity.UserVO;
import com.ecspringcloud.easycloud.provider.user.client.UserClient;
import com.ecspringcloud.easycloud.provider.user.entity.dto.UserDTO;
import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/8.
 */
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public ApiResult<UserDTO> findByIdFeign(@PathVariable Long id) {
        UserDTO user = this.userClient.getById(id);
        return successResultWithData(user);
    }

    @RequestMapping("/updateUser/{id}")
    public ApiResult updateUser(@PathVariable Long id,@RequestBody UserDTO userDTO){
        this.userClient.update(id,userDTO);
        return successResult();
    }
}
