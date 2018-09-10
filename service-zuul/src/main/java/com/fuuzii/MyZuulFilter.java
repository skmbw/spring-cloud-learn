package com.fuuzii;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yinlei
 * @since 2017/12/12 16:11
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyZuulFilter.class);

    /*
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤的顺序
    @Override
    public int filterOrder() {
        // 过滤器的优先级，越大越靠后执行
        return 0;
    }

    // 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            LOGGER.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                LOGGER.error("response error.", e);
            }

            return null;
        }
        LOGGER.info("ok");
        return null;
    }
}
