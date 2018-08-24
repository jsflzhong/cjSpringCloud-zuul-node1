package com.michael.springBoot;

import com.michael.springBoot.filters.TestFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author cuiji
 * @description 配置类
 * @date 2018/3/21
 */
@Configuration
public class WebConfiguration {

    /**
     * 远程ip过滤器. 作用暂时不明.
     * org.apache.catalina.filters.RemoteIpFilter
     * @return RemoteIpFilter
     * @author cj
     */
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    /**
     * 过滤器注册器. 把自定义的filter放入系统的拦截器链中.
     * org.springframework.boot.web.servlet.FilterRegistrationBean
     * @return FilterRegistrationBean
     * @author cj
     */
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TestFilter());
        registration.addUrlPatterns("/*"); //拦截url
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("TestFilter");
        registration.setOrder(1); //拦截器链中的所处顺序.
        return registration;
    }

}
