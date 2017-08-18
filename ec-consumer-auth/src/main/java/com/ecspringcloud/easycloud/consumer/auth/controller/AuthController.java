package com.ecspringcloud.easycloud.consumer.auth.controller;

import com.ecspringcloud.easycloud.common.base.ApiResult;
import com.ecspringcloud.easycloud.common.base.BaseController;
import com.ecspringcloud.easycloud.common.bean.Token;
import com.ecspringcloud.easycloud.common.enums.ResultEnum;
import com.ecspringcloud.easycloud.common.utils.Const;
import com.ecspringcloud.easycloud.common.utils.StringUtil;
import com.ecspringcloud.easycloud.consumer.auth.entity.AuthParams;
import com.ecspringcloud.easycloud.consumer.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunping
 * @create 2017/8/17
 */
@RestController
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;

    @RequestMapping("/getAuth")
    public ApiResult<String> getAuth(AuthParams authParams) {
        if (StringUtil.isAnyBlank(authParams.getUserName()) || StringUtil.isAnyBlank(authParams.getPassword())) {
            return failResult(ResultEnum.VERIFY_ERROR);
        }

        String token = authService.getAuthToken(authParams);
        if (!StringUtil.isAnyBlank(token)) {
            return successResultWithData(token);
        }
        return failResult(ResultEnum.VERIFY_ERROR);
    }

    /**
     * token字符串换token对象
     *
     * @param token
     * @return
     */
    @RequestMapping("/token/{token}")
    public ApiResult<Token> token(@PathVariable("token") String token) {
        //只能内部调用
        if(isOuterRequest()){
            return failResult(ResultEnum.VERIFY_ERROR);
        }
        if(StringUtil.isAnyBlank(token)){
            return failResult(ResultEnum.VERIFY_ERROR);
        }
        Token t = authService.getTokenData(token);
        if(t==null){
            return failResult(ResultEnum.VERIFY_ERROR);
        }
        return successResultWithData(t);
    }
}
