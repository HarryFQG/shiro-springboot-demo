package com.it.shiro.shirostateless.controller;

import com.it.shiro.shirostateless.entity.WxUser;
import com.it.shiro.shirostateless.shiro.service.PrincipalService;
import com.it.shiro.shirostateless.shiro.token.manager.TokenManager;
import com.it.shiro.shirostateless.shiro.token.token.StatelessToken;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author fengqigui
 * @description
 * @date 2018/03/07 17:45
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private PrincipalService<WxUser> principalService;

    @Autowired
    private TokenManager tokenManager;

    protected static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public StatelessToken login(String userCode, String password) {
        logger.info("userCode:"+userCode);
        WxUser usr = principalService.select(userCode);
        if (usr == null) {
            return new StatelessToken(userCode, "valid user");
        }
        if(!password.equals(usr.getPwd())){
            return new StatelessToken(userCode, "valid user password");
        }
        //成功穿件token返回给客户端保存
        StatelessToken createToken = tokenManager.createToken(userCode);
        return createToken;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        String authorization = getReqHeader(request,"authorization");
        StatelessToken token = tokenManager.getToken(authorization);
        if(token!= null){
            tokenManager.deleteToken(token.getUserCode());
        }
        SecurityUtils.getSubject().logout();
        logger.info("用户登出");
        return "logout success";
    }

    private String getReqHeader(HttpServletRequest req, String header){

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String nextElement = headerNames.nextElement();
            if(header.equals(nextElement)){
                return req.getHeader(nextElement);
            }
        }
        return null;
    }
}
