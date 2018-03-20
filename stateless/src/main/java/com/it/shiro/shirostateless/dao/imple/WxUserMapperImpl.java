package com.it.shiro.shirostateless.dao.imple;

import com.it.shiro.shirostateless.dao.WxUserMapper;
import com.it.shiro.shirostateless.entity.WxUser;
import org.springframework.stereotype.Repository;

/**
 * @author fengqigui
 * @description
 * @date 2018/03/07 17:52
 */
@Repository
public class WxUserMapperImpl implements WxUserMapper{
    @Override
    public WxUser selectOne(String user) {
        return new WxUser("admin","123456","admin");
    }
}
