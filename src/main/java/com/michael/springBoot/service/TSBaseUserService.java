package com.michael.springBoot.service;

import com.michael.springBoot.domain.TSBaseUser;

/**
 * @author cj
 * @description t_s_base_user的业务Service接口
 *      继承了自定义的基类Service接口.
 * @date 2018/3/23
 */
public interface TSBaseUserService extends BaseService<TSBaseUser> {

    /**
     * 这里可以定义除了基类Service接口定义的方法之外的方法.
     * 其它的基础方法都继承自了基类Service接口.
     * @param userId 用户id
     * @return TSBaseUser
     * @author cj
     */
    TSBaseUser getUserById(String userId);
}
