package com.it.shiro.shirostateless.entity;

/**
 * @author fengqigui
 * @description
 * @date 2018/03/07 17:22
 */
public class WxUser {

    private String username;

    private String pwd;

    private String userCode;

    public WxUser() {
    }

    public WxUser(String username, String pwd, String userCode) {

        this.username = username;
        this.pwd = pwd;
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "username='" + username + '\'' +
                ", sex='" + pwd + '\'' +
                ", userCode='" + userCode + '\'' +
                '}';
    }
}
