package com.codein.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xhuanlee on 2018/3/24.
 */
@Component
public class MyFilter extends ZuulFilter {

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
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("url: %s, port: %s, method: %s", request.getRequestURL().toString(), request.getServerPort(), request.getMethod()));

        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            System.out.println("token is null, access denied");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("access denied, token is empty, you have to provide valid token");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("token: " + token);
        }

        return null;
    }
}
