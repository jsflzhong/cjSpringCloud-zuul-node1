package com.michael.springBoot.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jsflz on 2018/7/28.
 * 自定义zuul的拦截器
 * pre型过滤器： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
 *
 * @author cj
 */
public class MyZullFilter_PRE extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(MyZullFilter_PRE.class);

    /**
     * 过滤器类型
     * pre： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
     * routing：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。
     * post：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
     * error：在其他阶段发生错误时执行该过滤器。
     *
     * @return 类型
     * @author cj
     */
    @Override
    public String filterType() {
        //定义filter的类型，有pre、route、post、error四种
        return "pre";
    }

    /**
     * 定义filter的顺序，数字越小表示顺序越高，越先执行
     *
     * @return 顺序
     * @author cj
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 表示是否需要执行该filter
     *
     * @return true表示执行，false表示不执行
     * @author cj
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * filter需要执行的具体操作
     * 测试根据请求中是否有token的存在,来决定是否路由本次请求
     *
     * @return null
     * @author cj
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("@@@My zuul filter is running...{},{}",
                request.getMethod(), request.getRequestURL());

        //检查令牌
        inspectToken(ctx);

        //验签
        inspectSign(ctx);

        //认证
        inspectAuthentication(ctx);

        //鉴权
        inspectAuthorization(ctx);

        return null;
    }

    /**
     * 检查令牌
     *
     * @param ctx RequestContext
     * @author cj
     */
    private boolean inspectToken(RequestContext ctx) {
        HttpServletRequest request = ctx.getRequest();
        //测试用token判断是否进行请求的路由
        String token = request.getParameter("token");
        if (StringUtils.isNotBlank(token)) {
            logger.info("@@@本次请求存在token,可以路由.token:{}", token);
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
        } else {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            logger.info("@@@本次请求不存在token,拒绝路由.");
        }
        return true;
    }

    /**
     * 验签
     *
     * @param ctx RequestContext
     * @author cj
     */
    private boolean inspectSign(RequestContext ctx) {
        return true;
    }

    /**
     * 认证
     *
     * @param ctx RequestContext
     * @author cj
     */
    private boolean inspectAuthentication(RequestContext ctx) {
        return true;
    }

    /**
     * 鉴权
     *
     * @param ctx RequestContext
     * @author cj
     */
    private boolean inspectAuthorization(RequestContext ctx) {
        return true;
    }

}
