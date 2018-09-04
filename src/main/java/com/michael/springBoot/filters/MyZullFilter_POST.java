package com.michael.springBoot.filters;

import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.fastjson.JSONObject;
import com.michael.springBoot.springCloud.ProducerFusing;
import com.netflix.discovery.converters.Auto;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.http.HttpServletResponseWrapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Created by jsflz on 2018/7/28.
 * 自定义zuul的拦截器
 * post型：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
 * <p>
 * 本filter的作用是,如果请求的"指定的服务"都不可用(由eureka admin下线的),则返回熔断信息.
 *
 * @author cj
 */
public class MyZullFilter_POST extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(MyZullFilter_POST.class);

    //指定的服务名
    //private static final String SIGN_SERVICE = "sign-service";
    private static final String SPRING_CLOUD_PRODUCER = "spring-cloud-producer";

    @Autowired
    private ProducerFusing producerFusing;

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
        return "post";
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

        //这里可以修改response响应值
        modifyResponse(ctx);

        return null;
    }

    /**
     * 修改response响应值
     *
     * @param ctx RequestContext
     * @author cj
     */
    private boolean modifyResponse(RequestContext ctx) {
       /* ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(400);
        ctx.getResponse().setCharacterEncoding("UTF-8");
        ctx.setResponseBody("response响应值");
        ctx.set("isSuccess", false);*/
        return true;
    }

}
