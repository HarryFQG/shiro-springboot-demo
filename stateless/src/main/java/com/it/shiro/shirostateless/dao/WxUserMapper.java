package com.it.shiro.shirostateless.dao;

import com.it.shiro.shirostateless.entity.WxUser;

/**
 * @author fengqigui
 * @description
 * @date 2018/03/07 17:21
 */

public interface WxUserMapper {


    WxUser selectOne(String codeUser);
}
