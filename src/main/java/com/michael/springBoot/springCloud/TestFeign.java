package com.michael.springBoot.springCloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign调用接口
 * 作为服务消费者,测试远程调用通过注册中心提供的服务.
 * 2018/3/28
 * @author cj
 */
//1.需指向服务提供者的配置中的spring.application.name=的值.
@FeignClient(name="spring-cloud-producer",fallback = TestHystrix.class) //5.需要指定hystrix阻断回调的实现类.
public interface TestFeign { //2.Controller中需要DI这个接口!

    @RequestMapping(value = "/testHello") //3.这个要与服务提供者的目标handler的url一致!!
    String testHello(@RequestParam(value = "name") String name); //4.这个注解是否必须?
}
