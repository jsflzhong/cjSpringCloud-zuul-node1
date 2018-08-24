package com.michael.springBoot.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author cj
 * @description 测试取出properties配置文件中的key value
 * @date 2018/3/21
 */
@Component
public class TestProperties {

    //测试log.配置在application.properties配置文件中.
    protected static final Logger logger = LoggerFactory.getLogger(TestProperties.class);

    //测试从application.properties配置文件中用注解拿出配置.
    @Value("${test1}")
    private String test1;
    @Value("${test2}")
    private String test2;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public String testPropertiesAndLog() {
        logger.info("SpringBoot的log功能测试========");
        return "从properties中加载配置=======test1: " + test1 + ",test2: " + test2;
    }
}
