package com.gcbi.damo.cotroller.interceptor;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.gcbi.cloud.common.constant.ResultCode;
import com.gcbi.cloud.common.core.auth.AuthUtils;
import com.gcbi.cloud.common.core.web.controller.AjaxControllerAnn;
import com.gcbi.cloud.common.core.web.controller.HtmlControllerAnn;
import com.gcbi.cloud.common.model.auth.AuthSession;
import com.gcbi.cloud.common.model.base.GeneralResult;
import com.gcbi.damo.client.GcuserClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    GcuserClient gcuserClient;

    @Value("${loginUrl}")
    String loginUrl;

    @Override
    public boolean preHandle(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object handler)
            throws Exception {

        String authId = AuthUtils.getAuthId(httpRequest);
        log.debug("authId is: " + authId);

        AuthSession authSession = null;
        if (StringUtils.isNotBlank(authId)) {
            authSession = gcuserClient.checkAuth(authId, AuthUtils.isKeepSignedIn(httpRequest));
        } else {
            log.debug("authId is null");
        }
        if (authSession == null) {
            log.warn("AuthId[{}] is timeout.", authId);
            if (handler instanceof HandlerMethod) {
                if (((HandlerMethod) handler).getBean().getClass().getAnnotation(HtmlControllerAnn.class) != null) {
                    handleHtmlTimeout(httpRequest, httpResponse);
                } else if (((HandlerMethod) handler).getBean().getClass()
                        .getAnnotation(AjaxControllerAnn.class) != null) {
                    handleAjaxTimeout(httpResponse);
                }
            }
            return false;
        }
        AuthUtils.saveAuthId2Cookie(httpRequest, httpResponse, authId);
        AuthUtils.saveAuthId2Session(httpRequest, authId);
        AuthUtils.saveAuthSession(httpRequest, authSession);
        MDC.put("userLoggerName", authSession.getMobile());
        return true;
    }

    private void handleHtmlTimeout(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
        String callbackUrl = httpRequest.getRequestURL().toString();
        String redirectUrl = loginUrl + "?callback=" + callbackUrl;
        log.warn("Redirect the request to: {}", redirectUrl);
        httpResponse.sendRedirect(redirectUrl);
    }

    private void handleAjaxTimeout(HttpServletResponse httpResponse) throws IOException {
        log.debug("html AuthId[{}] is timeout");
        GeneralResult <String> webResult = new GeneralResult <String>(ResultCode.ERR_AUTH_TIMEOUT, "Login timeout");
        String json = JSON.toJSONString(webResult);
        OutputStream os = httpResponse.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.flush();
    }
}
