package com.it.shiro.shirostateless.shiro.token;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fengqigui
 * @description ehcache用户令牌帮助类 (redsi 也可以)
 * @date 2018/03/07 16:56
 */
@Component
public class EhCacheUserTokenHelper implements UserTokenOperHelper {
    /**
     * 对应ehcache.xml cache Name
     */
    private String userTokenCacheName ="userTokenCache";

    /**
     * ehcache缓存管理器
     */

    private CacheManager cacheManager;
    @Override
    public String getUserToken(String userCode){
        Cache cache = getUserTokenCache();
        if (cache == null) {
            return "cache123";
            // return null;
        }else{
            Element element = cache.get(userCode);
            List keys = cache.getKeys();
            for (Object object : keys) {
                System.out.println(object);
            }
            if(element == null){
                return null;
            }else{
                Object objectValue = element.getObjectValue();
                if(objectValue == null){
                    return null;
                }else{
                    return (String)objectValue;
                }
            }
        }
    }

    public Cache getUserTokenCache(){
        CacheManager cacheManager = new CacheManager();
        Cache cache = cacheManager.getCache(userTokenCacheName);

        return cache;
    }
    @Override
    public void updateUserToken(String userCode,String token,long seconds){
        Cache cache = getUserTokenCache();
        Element e = new Element(userCode, token);
        e.setTimeToLive(new Long(seconds).intValue());
        cache.put(e);
        List keys = cache.getKeys();
        for (Object object : keys) {
            System.out.println(object);
        }
    }
    @Override
    public void deleteUserToken(String userCode){
        Cache cache = getUserTokenCache();
        cache.remove(userCode);
    }

    public String getUserTokenCacheName() {
        return userTokenCacheName;
    }

    public void setUserTokenCacheName(String userTokenCacheName) {
        this.userTokenCacheName = userTokenCacheName;
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
}
