package com.it.shiro.shirostateless.shiro.token.manager;

import com.it.shiro.shirostateless.shiro.token.token.StatelessToken;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author fengqigui
 * @description 默认token管理实现类
 * @date 2018/03/07 17:06
 */
@Component
public class DefaultTokenManagerImpl extends AbstractTokenManager {
    @Override
    public String createStringToken(String userCode) {
        //创建简易的32为uuid
        return UUID.randomUUID().toString().replace("-", "");
    }


    @Override
    public boolean checkToken(StatelessToken model) {
        return super.checkMemoryToken(model);
    }
}

