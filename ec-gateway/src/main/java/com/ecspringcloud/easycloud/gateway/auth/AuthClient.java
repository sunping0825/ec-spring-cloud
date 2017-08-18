package com.ecspringcloud.easycloud.gateway.auth;

import com.ecspringcloud.easycloud.common.base.ApiResult;
import com.ecspringcloud.easycloud.common.bean.Token;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sunping
 * @create 2017/8/17
 */
@FeignClient(name = "ec-consumer-auth")
public interface AuthClient {
    @RequestMapping(value = "/token/{token}")
    public ApiResult<Token> token(@PathVariable("token") String token);
}
