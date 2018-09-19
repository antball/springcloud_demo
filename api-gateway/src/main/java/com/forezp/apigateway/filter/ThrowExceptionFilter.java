package com.forezp.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: huangsj
 * @Date: 2018/9/8 09:05
 * @Description:
 */
public class ThrowExceptionFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);

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

//    @Override
//    public Object run() {
//        log.info("This is a pre filter, it will throw a RuntimeException");
//        doSomething();
//        return null;
//    }

    @Override
    public Object run() {
        log.info("This is a pre filter, it will throw a RuntimeException");
        RequestContext ctx = RequestContext.getCurrentContext();
//        try {
//            doSomething();
//        } catch (Exception e) {
//            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            ctx.set("error.exception", e);
//        }

        try {
            doSomething();
        } catch (Throwable t) {
            throw new ZuulRuntimeException(new ZuulException(t, HttpStatus.BAD_REQUEST.value(), t.getMessage()));
//            http://www.springcloud.cn/view/22
//            https://www.jianshu.com/p/632f26892c44
        }

        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors...");
    }





}