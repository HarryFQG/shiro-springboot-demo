package com.it.shiro.shirostateless.shiro.token;

/**
 * @author fengqigui
 * @description 用户令牌操作接口
 * @date 2018/03/07 16:55
 */
public interface UserTokenOperHelper {

    /**
     * 根据用户编码获取令牌
     * @param userCode
     * @return
     */
    public String getUserToken(String userCode);

    /**
     * 更新令牌， 每次获取令牌成功时更新令牌失效时间
     * @param userCode
     * @param token
     * @param seconds
     */
    public void updateUserToken(String userCode,String token,long seconds);

    /**
     * 删除令牌
     * @param userCode
     */
    public void deleteUserToken(String userCode);
}
