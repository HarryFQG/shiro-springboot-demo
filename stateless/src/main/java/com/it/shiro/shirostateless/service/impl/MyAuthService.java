package com.it.shiro.shirostateless.service.impl;

import com.it.shiro.shirostateless.dao.WxUserMapper;
import com.it.shiro.shirostateless.service.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengqigui
 * @description
 * @date 2018/03/07 17:08
 */
@Service
@CacheConfig(cacheNames="role")
public class MyAuthService implements AuthorizationService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Override
    @Cacheable
    public List<String> selectRoles(String principal) {
        List<String> roles = new ArrayList<String>();
        //从数据库获取权限并设置
        logger.info("add roles");
        if("admin".equals(principal)){
            roles.add("admin");
            roles.add("vistor");
        }
        return roles;

    }

}
