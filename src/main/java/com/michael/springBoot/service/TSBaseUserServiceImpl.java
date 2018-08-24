package com.michael.springBoot.service;

import com.michael.springBoot.dao.TSBaseUserMapper;
import com.michael.springBoot.domain.TSBaseUser;
import com.michael.springBoot.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cj
 * @description t_s_base_user的业务Service实现
 *      继承了自定义的基类Service实现.
 *      所有由上层业务接口TSBaseUserService继承自基层通用接口BaseService的方法定义,
 *      都已经由这里继承的基类通用接口的实现BaseServiceImpl,所实现了.
 * @date 2018/3/23
 */
@Service
public class TSBaseUserServiceImpl extends BaseServiceImpl<TSBaseUser> implements TSBaseUserService {

    @Autowired
    private TSBaseUserMapper tsBaseUserMapper;

    /**
     * 测试自定义的方法是否有效.
     * @param userId 用户id
     * @return TSBaseUser
     */
    @Override
    public TSBaseUser getUserById(String userId) {
        return tsBaseUserMapper.getUserById(userId);
    }
}
