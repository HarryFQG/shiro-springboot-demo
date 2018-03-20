package com.it.shiro.shirostateless.service;

import java.util.List;

/**
 * @author fengqigui
 * @description 基础类
 * @date 2018/03/07 17:19
 */
public interface AuthorizationService {

    List<String> selectRoles(String principal);

}
