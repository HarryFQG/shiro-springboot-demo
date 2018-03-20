package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.User;
import com.study.model.UserRole;

/**
 *  @author  fengqigui
 *  @date 2017/12/23.
 */
public interface UserService extends IService<User>{
    PageInfo<User> selectByPage(User user, int start, int length);

    User selectByUsername(String username);

    void delUser(Integer userid);

}
