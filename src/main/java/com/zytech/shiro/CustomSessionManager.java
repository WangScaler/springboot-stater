package com.zytech.shiro;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @Description：自定义SessionManager
 * @Author：WangScaler
 * @Date：2021/02/19 4:54 下午
 * @Versiion：1.0
 */
public class CustomSessionManager extends DefaultWebSessionManager {
    public static final String AUTHORIZATION="token";

    public CustomSessionManager() {
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        //获取sessionId
        String sessionId= WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        if (sessionId!=null){
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
                    ShiroHttpServletRequest.COOKIE_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return sessionId;
        }else {
            return super.getSessionId(request,response);
        }
    }
}
