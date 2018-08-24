package com.michael.springBoot.dao;

import com.michael.springBoot.domain.TSBaseUser;

public interface TSBaseUserMapper extends BaseMapper<TSBaseUser> {

    /**
     * 这里可以定义除了基类dao接口定义的方法之外的方法.
     * 其它的基础方法都继承自了基类dao接口.
     * @param userId 用户id
     * @return TSBaseUser
     * @author cj
     */
    TSBaseUser getUserById(String userId);
}