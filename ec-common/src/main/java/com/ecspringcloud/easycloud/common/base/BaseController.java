package com.ecspringcloud.easycloud.common.base;

import com.ecspringcloud.easycloud.common.enums.ResultEnum;

/**
 * Created by Administrator on 2017/8/15.
 */
public class BaseController {

    /**
     * 返回成功结果
     * @return
     */
    protected ApiResult successResult(){
        return result(ResultEnum.SUCCESS.getValue(),ResultEnum.SUCCESS.getName());
    }

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
