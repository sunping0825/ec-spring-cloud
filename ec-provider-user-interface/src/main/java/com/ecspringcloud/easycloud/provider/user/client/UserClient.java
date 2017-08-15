package com.ecspringcloud.easycloud.provider.user.client;

import com.ecspringcloud.easycloud.provider.user.entity.dto.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/8.
 */
@FeignClient(name = "ec-provider-user")
public interface UserClient {
    @RequestMapping(value = "/get/{id}")
    public UserDTO getById(@PathVariable("id") Long id);

    @RequestMapping(value = "/save")
    public void save(UserDTO userDTO);

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST,consumes = "application/json")
    public void update(@PathVariable("id") Long id, @RequestBody UserDTO userDTO);
}
