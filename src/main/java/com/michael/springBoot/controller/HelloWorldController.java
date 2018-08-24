package com.michael.springBoot.controller;

import com.alibaba.druid.util.StringUtils;
import com.michael.springBoot.domain.TSBaseUser;
import com.michael.springBoot.domain.User;
import com.michael.springBoot.service.TSBaseUserService;
import com.michael.springBoot.service.UserService;
import com.michael.springBoot.tools.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author cuiji
 * @description spring-boot第一个测试用Controller
 * @date 2018/3/21
 */
@Controller
public class HelloWorldController {

    //测试配置类.
    @Autowired
    private TestProperties testProperties;
    @Autowired
    private UserService userService;
    @Autowired
    private TSBaseUserService tsBaseUserService;

    /**
     * hello world handler
     * @return json
     * @author cj
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String index() {
        return "hello world!!!~~";
    }

    /**
     * properties handler
     * @return json
     * @author cj
     */
    @RequestMapping("/testProperties")
    @ResponseBody
    public String testProperties() {
        return testProperties.testPropertiesAndLog();
    }

    /**
     * user get handler
     * @return json
     * @author cj
     */
    @RequestMapping("/testGetUser")
    @ResponseBody
    public Object testGetUserById(Integer userId) {
        return userService.getUserById(userId);
    }

    /**
     * user add handler
     * @return json
     * @author cj
     */
    @RequestMapping("/testAddUser")
    @ResponseBody
    public Object testAddUser(String id) {
        User user = new User();
        user.setId(id);
        user.setAge(11);
        user.setPassword("123");
        user.setUsername("test" + id);
        return userService.addUser(user);
    }

    /**
     * test transaction handler
     * @return json
     * @author cj
     */
    @RequestMapping("/testTransaction")
    @ResponseBody
    public Object testTransaction(String id) {
        User user = new User();
        user.setId(id);
        user.setAge(11);
        user.setPassword("123");
        user.setUsername("test" + id);
        return userService.testTransaction(user);
    }

    /**
     * test jsp handler
     * @return json
     * @author cj
     */
    @RequestMapping("/testJsp")
    public String testJsp(String sayHi, HttpServletRequest request) {
        request.setAttribute("hello",sayHi);
        return "hello";
    }

    /**
     * test baseService and baseDao handler
     * 测试自定义的基类通用dao和基类通用service--save方法
     * @return json
     * @author cj
     */
    @RequestMapping("/testBaseSave")
    @ResponseBody
    public String testBaseSave() {
        //调用继承自基类Service的方法.
        int lines = tsBaseUserService.save(getRandomUser());
        return lines > 0 ? "success" : "fail";
    }

    /**
     * test baseService and baseDao handler
     * 测试自定义的基类通用dao和基类通用service--select方法
     * @param key 要查的目标数据的主键id
     * @return json
     * @author cj
     */
    @RequestMapping("/testBaseSelect")
    @ResponseBody
    public String testBaseSelect(String key) {
        //调用继承自基类Service的方法.
        TSBaseUser baseUser = tsBaseUserService.selectByKey(key);
        if(baseUser != null && !StringUtils.isEmpty(baseUser.getId())) {
            return "success";
        }
        return "fail";
    }

    /**
     * test baseService and baseDao handler
     * 测试自定义的基类通用dao和基类通用service--delete方法
     * @param key 要删除的目标数据的主键id
     * @return json
     * @author cj
     */
    @RequestMapping("/testBaseDelete")
    @ResponseBody
    public String testBaseDelete(String key) {
        //调用继承自基类Service的方法.
        int lines = tsBaseUserService.delete(key);
        return lines > 0 ? "success" : "fail";
    }

    /**
     * test baseService and baseDao handler
     * 测试自定义的基类通用dao和基类通用service--update方法
     * @param key 要删除的目标数据的主键id
     * @return json
     * @author cj
     */
    @RequestMapping("/testBaseupdate")
    @ResponseBody
    public String testBaseupdate(String key) {
        //调用继承自基类Service的方法.
        TSBaseUser tsBaseUser = new TSBaseUser();
        tsBaseUser.setId(key);
        tsBaseUser.setPassword("999999");
        int lines = tsBaseUserService.updateNotNull(tsBaseUser);
        return lines > 0 ? "success" : "fail";
    }

    /**
     * test baseService and baseDao handler
     * 测试自定义的基类通用dao和基类通用service中的自定义的方法
     * @param key 要查询的目标数据的主键id
     * @return json
     * @author cj
     */
    @RequestMapping("/testGet")
    @ResponseBody
    public String testGet(String key) {
        //调用继承自基类Service的方法.
        TSBaseUser baseUser = tsBaseUserService.getUserById(key);
        if(baseUser != null && !StringUtils.isEmpty(baseUser.getId())) {
            return "success";
        }
        return "fail";
    }







    /**#########################################private######################################*/

    /**
     * 获得一个UUID
     * @return 去横线后的uuid
     * @author cj
     */
    private String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 获得一个ID为随机字符串的t_s_base_use pojo.
     * @return TSBaseUser
     * @author
     */
    private TSBaseUser getRandomUser() {
        String uuid = getUUID();
        System.out.println("getRandomUser()================the uuid created this time is : " + uuid);
        TSBaseUser tsBaseUser = new TSBaseUser();
        tsBaseUser.setId(uuid);
        tsBaseUser.setUsername("test" + uuid.substring(0,3));
        tsBaseUser.setPassword("888888");
        return tsBaseUser;
    }


}
