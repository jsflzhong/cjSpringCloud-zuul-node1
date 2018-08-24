package com.michael.springBoot;

import com.michael.springBoot.dao.BaseMapper;
import com.michael.springBoot.filters.MyZullFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = "com.michael.springBoot.dao", markerInterface = BaseMapper.class)
//@EnableScheduling
//@EnableEurekaServer
@EnableZuulProxy
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 将自定义的zuul过滤器加入启动队列
     *
     * @return 自定义的zuul过滤器
     * @author cj
     */
    @Bean
    public MyZullFilter tokenFilter() {
        return new MyZullFilter();
    }
}
