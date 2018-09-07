package com.forezp.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: huangsj
 * @Date: 2018/9/7 17:17
 * @Description:
 */
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    public static final String ERROR_STATUS_CODE = "error.status_code";

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
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        try {
//        模拟异常
            doSomething();


            Object accessToken = request.getParameter("accessToken");
            if(accessToken == null) {
                log.warn("access token is empty");
                context.setSendZuulResponse(false);
                context.setResponseStatusCode(401);
                return null;
            }
            log.info("access token ok");

//        }catch (ZuulException ex) {
//            context.set(ERROR_STATUS_CODE, ex.nStatusCode);
//            context.set("error.message", ex.errorCause);
//            context.set("error.exception", ex);
        }catch (Exception ex) {
            context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            context.set("error.message", ex.getMessage());
            context.set("error.exception", ex);
        }

        return null;
    }


    private void doSomething() {
        throw new RuntimeException("Exist some errors...");
    }

}