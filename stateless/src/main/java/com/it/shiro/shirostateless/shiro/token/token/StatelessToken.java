package com.it.shiro.shirostateless.shiro.token.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author fengqigui
 * @description
 * @date 2018/03/07 17:27
 */
public class StatelessToken implements AuthenticationToken {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String userCode;

    private String token;

    public StatelessToken(String userCode, String token){
        this.userCode = userCode;
        this.token = token;
    }


    @Override
    public Object getPrincipal() {
        return userCode;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getToken() {
        return token;
    }
}
