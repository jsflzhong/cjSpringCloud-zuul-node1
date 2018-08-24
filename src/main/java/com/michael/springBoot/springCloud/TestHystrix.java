package com.michael.springBoot.springCloud;

import org.springframework.stereotype.Component;

/**
 * 测试阻断器hystrix的回调类
 * 在服务提供者提供的服务不可用时,会通过调用该类中的重写方法,来通知服务消费者错误信息.
 * 需要实现自己的Feign接口.
 * 注意: 这里所实现的,即之前自己的Feign接口,是不用任何实现类就能用其来调用远程服务的!
 *      这个实现类之所以要实现那个接口,目前只是为了编写阻断后的回调信息而已!
 * 注意: 需要在上层接口那边,用注解指定一下本实现类!
 * 2018/3/29
 * @author cj
 */
@Component //记得需要加入IOC
public class TestHystrix implements TestFeign{

    /**
     * 实现自己的Feign接口中的方法.
     * @param name 普通测试用字符串.
     * @return 由于服务提供者出现错误,而导致阻断后,会返回这个方法中所返回的提示信息.
     * @author cj
     */
    @Override
    public String testHello(String name) {
        return "Hi there, i am the hystrix message in node5, interface:TestHystrix and method:testHello !";
    }
}
