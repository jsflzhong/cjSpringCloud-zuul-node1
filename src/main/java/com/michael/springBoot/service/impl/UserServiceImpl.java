package com.michael.springBoot.service.impl;

import com.michael.springBoot.dao.UserMapper;
import com.michael.springBoot.domain.User;
import com.michael.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cuiji
 * @description
 * @date 2018/3/21
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userDao;

    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    public boolean addUser(User user) {
        boolean result = false;
        try {
            userDao.insertSelective(user);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean testTransaction(User user) {
        int lines = userDao.insertSelective(user);
        int i = 1/0;
        System.out.println(i);
        return lines > 0;
    }
}
