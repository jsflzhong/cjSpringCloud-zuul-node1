package com.michael.springBoot.controller;

import com.michael.springBoot.springCloud.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * springCloud测试controller
 * 2018/3/28
 * @author cj
 */
@Controller
public class SpringCloudController {

    //DI feign的接口,与spring的RPC类似.
    @Autowired
    private TestFeign testFeign;

    /**
     * 测试通过eureka服务注册中心,来调用远程服务.
     * @param name 用户名 随意写,会经由feign接口传递给远程的服务提供者.
     * @return String
     * @author cj
     */
    @RequestMapping("/testCallRemoteService")
    @ResponseBody
    public Object testCallRemoteService(String name) {
        //用feign接口,调用远程的服务提供者.
        return testFeign.testHello(name) + "=========guess what? i am the consumer!";
    }


}
