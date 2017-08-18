package com.ecspringcloud.easycloud.provider.user.controller;

import com.ecspringcloud.easycloud.provider.user.client.UserClient;
import com.ecspringcloud.easycloud.provider.user.entity.dto.LoginDTO;
import com.ecspringcloud.easycloud.provider.user.entity.dto.UserDTO;
import com.ecspringcloud.easycloud.provider.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/8/8.
 */
@RestController
public class UserController implements UserClient {

    @Autowired
    private UserService userService;

    @Override
    @RequestMapping(value="/get/{id}")
    public UserDTO getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @Override
    @RequestMapping(value = "/save",method = RequestMethod.POST,consumes = "application/json")
    public void save(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
    }

    @Override
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST,consumes = "application/json")
    public void update(@PathVariable("id")  Long id,@RequestBody UserDTO userDTO) {
        userService.update(id,userDTO);
    }

    @Override
    @RequestMapping(value = "/login",method = RequestMethod.POST,consumes = "application/json")
    public UserDTO login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }
}
