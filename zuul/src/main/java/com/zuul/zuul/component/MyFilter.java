package com.zuul.zuul.component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author zhaomengxia
 * @create 2019/8/28 11:45
 */
@Component
public class MyFilter extends ZuulFilter {
    /**
     * filterType返回一个字符串代表过滤器的类型，在zuul定义了四种不同的生命周期的过滤器类型
     * pre指路由之前
     * routing路由之后
     * post路由之后
     * error发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter这里可以写逻辑判断，是否过滤，本文位true，永远过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑，可以很复杂，包括sql、nosql去判断请求到底有没有权限访问
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext context= RequestContext.getCurrentContext();

        HttpServletRequest request=context.getRequest();

        Object accessToken=request.getParameter("token");
        if (accessToken==null){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
