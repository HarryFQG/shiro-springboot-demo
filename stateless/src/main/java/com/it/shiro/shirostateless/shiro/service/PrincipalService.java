package com.it.shiro.shirostateless.shiro.service;

/**
 * @author fengqigui
 * @description 用户服务
 * @date 2018/03/07 16:53
 */
public interface PrincipalService <T> {

    /**
     * 根据用户id获取用户信息
     * @param principal
     * @return
     */
    T select(String principal);

}
