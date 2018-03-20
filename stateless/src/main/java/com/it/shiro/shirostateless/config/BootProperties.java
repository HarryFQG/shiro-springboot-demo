package com.it.shiro.shirostateless.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author fengqigui
 * @description
 * @date 2018/03/07 16:47
 */
@Component
@ConfigurationProperties(prefix = "shiro.token")
public class BootProperties {

    private String key;

    private long expirateTime;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getExpirateTime() {
        return expirateTime;
    }

    public void setExpirateTime(long expirateTime) {
        this.expirateTime = expirateTime;
    }



}