package com.ecspringcloud.easycloud.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.ecspringcloud.easycloud.common.base.ApiResult;
import com.ecspringcloud.easycloud.common.bean.Token;
import com.ecspringcloud.easycloud.common.utils.Const;
import com.ecspringcloud.easycloud.common.utils.StringUtil;
import com.ecspringcloud.easycloud.gateway.auth.AuthClient;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/8.
 */
@Component
public class RequestFilter extends ZuulFilter {

    @Autowired
    private AuthClient authClient;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //每一个从外部来的请求都加一个标识
        requestContext.addZuulRequestHeader(Const.GATEWAY_HEAD_KEY, Const.GATEWAY_HEAD_VALUE);
        //token换jwt
        //先看header里面是否带有token
        String token = requestContext.getRequest().getHeader(Const.CLIENT_HEADER_TOKEN_KEY);
        if (StringUtil.isAnyBlank(token)) {
            //再看请求是否带有token
            token = requestContext.getRequest().getParameter(Const.CLIENT_TOKEN_KEY);
        }
        String jwt="";
        //如果有token，就换成jwt
        if (!StringUtil.isAnyBlank(token)) {
            ApiResult<Token> result=this.authClient.token(token);
            if(result.getStatus()==0){
                jwt= JSON.toJSONString(result.getData());
            }
        }
        requestContext.addZuulRequestHeader(Const.GATEWAY_JWT_KEY,jwt);
        return null;
    }
}
