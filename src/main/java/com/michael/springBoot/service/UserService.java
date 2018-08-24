package com.michael.springBoot.service;

import com.michael.springBoot.domain.User;

/**
 * @author cuiji
 * @description 测试user的Serivce层
 * @date 2018/3/21
 */
public interface UserService extends BaseService<User> {

    User getUserById(int userId);

    boolean addUser(User record);

    boolean testTransaction(User record);
}
