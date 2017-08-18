package com.ecspringcloud.easycloud.common.base;

import com.alibaba.fastjson.JSON;
import com.ecspringcloud.easycloud.common.bean.Token;
import com.ecspringcloud.easycloud.common.enums.ResultEnum;
import com.ecspringcloud.easycloud.common.utils.Const;
import com.ecspringcloud.easycloud.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunping
 * @create 2017/8/17
 */
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    /**
     * 是否外部请求
     * @return
     */
    protected boolean isOuterRequest() {
        String value = request.getHeader(Const.GATEWAY_HEAD_KEY);
        if (value != null && value.equals(Const.GATEWAY_HEAD_VALUE)) {
            return true;
        }
        return false;
    }

    /**
     * 获取token对象
     * @return
     */
    protected Token getToken(){
        String jwt=request.getHeader(Const.GATEWAY_JWT_KEY);
        if(StringUtil.isAnyBlank(jwt)){
           return null;
        }
        return JSON.parseObject(jwt,Token.class);
    }


    /**
     * 返回成功结果
     * @return
     */
    protected ApiResult successResult(){
        return result(ResultEnum.SUCCESS.getValue(),ResultEnum.SUCCESS.getName());
    }

    /**
     * 返回成功结果带数据
     * @param data
     * @return
     */
    protected ApiResult successResultWithData(Object data){
        ApiResult result=successResult();
        result.setData(data);
        return result;
    }

    /**
     * 返回成功结果
     * @param message
     * @return
     */
    protected ApiResult successResult(String message){
        return result(ResultEnum.SUCCESS.getValue(),message);
    }

    /**
     * 返回失败结果
     * @param resultEnum
     * @return
     */
    protected ApiResult failResult(ResultEnum resultEnum){
        return result(resultEnum.getValue(),resultEnum.getName());
    }

    /**
     * 返回失败结果
     * @param status
     * @param message
     * @return
     */
    protected ApiResult failResult(Integer status,String message){
        return result(status,message);
    }

    /**
     * 结果
     * @param status
     * @param message
     * @return
     */
    private ApiResult result(Integer status,String message){
        ApiResult apiResult=new ApiResult();
        apiResult.setStatus(status);
        apiResult.setMessage(message);
        return apiResult;
    }


}
