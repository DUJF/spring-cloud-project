package com.github.zuul.handler;

import com.github.common.core.RespBody;
import com.github.common.util.JwtUtils;
import com.github.zuul.config.FilterConfig;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dellll
 */
@Component
public class MyFilter extends ZuulFilter {

    private Logger log = LoggerFactory.getLogger(MyFilter.class);


    @Autowired
    private FilterConfig filterConfig;

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * <p>
     * filterOrder：过滤的顺序
     * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        String ignoresParam = filterConfig.getIgnores();
        String[] ignoreArray = ignoresParam.split(",");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        log.info("==========" + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object token = request.getHeader("token");
        if (token == null || token.equals("null")) {
            token = null;
            //测试需要正常不用返回
            return null;
        }

        boolean flag = false;

        for (int i = 0; i < ignoreArray.length; i++) {
            System.out.println(request.getRequestURL().toString() + "|" + ignoreArray[i]);
            if (request.getRequestURL().toString().contains(ignoreArray[i])) {
                flag = true;
            }
        }


//        if(!request.getRequestURL().toString().contains("addUser")&&!request.getRequestURL().toString().contains("login")&&
//        		!request.getRequestURL().toString().contains("logout")&&token == null) {


        if (!flag && token == null) {

            log.info("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token is empty");
            return null;

        } else if (!flag && token != null) {

            try {
//                JwtUtils.verify(token);

//                if(!respBody.getMsg().equals("success")){
//
//                    log.info("filter ========="+respBody.getMsg());
//                    ctx.setSendZuulResponse(false);
//                    ctx.setResponseStatusCode(401);
//                    ctx.setResponseBody(respBody.getMsg());
//
//                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

//            log.info("chekcToken==="+respBody.getMsg());

        }
        log.info("access token ok");
        return null;
    }
}
