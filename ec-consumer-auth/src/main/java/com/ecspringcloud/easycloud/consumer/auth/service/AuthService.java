package com.ecspringcloud.easycloud.consumer.auth.service;

import com.ecspringcloud.easycloud.common.bean.Token;
import com.ecspringcloud.easycloud.consumer.auth.entity.AuthParams;
import com.ecspringcloud.easycloud.provider.user.client.UserClient;
import com.ecspringcloud.easycloud.provider.user.entity.dto.LoginDTO;
import com.ecspringcloud.easycloud.provider.user.entity.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author sunping
 * @create 2017/8/17
 */
@Service
public class AuthService {

    private static HashMap<String,Token> TOKEN_MAP=new HashMap<>();

    @Autowired
    private UserClient userClient;

    /**
     * 获取授权
     *
     * @param authParams
     * @return
     */
    public String getAuthToken(AuthParams authParams) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(authParams.getUserName());
        loginDTO.setPassword(authParams.getPassword());
        UserDTO userDTO = this.userClient.login(loginDTO);
        if (userDTO != null) {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            Token t = new Token();
            t.setName(userDTO.getName());
            t.setToken(token);
            saveToken(token, t);
            return token;
        } else {
            return null;
        }
    }

    /**
     * 获取token数据
     *
     * @param token
     * @return
     */
    public Token getTokenData(String token) {
        return getToken(token);
    }

    /**
     * 保存token
     *
     * @param token
     * @param t
     */
    private void saveToken(String token, Token t) {
        TOKEN_MAP.put(token, t);
        //TODO 换成redis
    }

    /**
     * 获取token数据
     *
     * @param token
     * @return
     */
    private Token getToken(String token) {
        return TOKEN_MAP.get(token);
        //TODO 换成redis
    }
}
