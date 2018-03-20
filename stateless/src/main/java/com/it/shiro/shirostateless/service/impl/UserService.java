package com.it.shiro.shirostateless.service.impl;

import com.it.shiro.shirostateless.dao.WxUserMapper;
import com.it.shiro.shirostateless.entity.WxUser;
import com.it.shiro.shirostateless.shiro.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author fengqigui
 * @description
 * @date 2018/03/07 17:23
 */
@Service
@CacheConfig(cacheNames="wxUser")
public class UserService  implements PrincipalService<WxUser> {


    @Autowired
    private WxUserMapper userMapper;

    @Override
    public WxUser select(String principal) {
        return userMapper.selectOne(principal);
    }

    @Cacheable
    public WxUser getUserByUserCode(String userCode){
        WxUser user = new WxUser();
        user.setUserCode(userCode);
        return userMapper.selectOne(userCode);
    }
}
