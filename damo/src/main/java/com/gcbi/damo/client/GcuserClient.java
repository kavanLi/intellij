package com.gcbi.damo.client;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gcbi.base.remote.BaseRemoteService;
import com.gcbi.base.remote.RemoteApiResponse;
import com.gcbi.cloud.common.model.auth.AuthSession;
import com.gcbi.gcuser.api.AuthApi;

@Component
public class GcuserClient extends BaseRemoteService {

    @Autowired
    AuthApi authApi;

    /**
     * checkAuth
     *
     * @param authId
     * @param isKeepSignedIn
     * @return
     */
    public AuthSession checkAuth(String authId, boolean isKeepSignedIn) {
        RemoteApiResponse <com.gcbi.gcuser.model.AuthSession> resp = authApi.checkAuth(authId, true, isKeepSignedIn);
        if (resp.isSuccess()) {
            if (resp.getData() == null) {
                return null;
            }
            AuthSession retSession = new AuthSession();
            BeanUtils.copyProperties(resp.getData(), retSession);
            return retSession;
        }
        handleErrorResp(resp, "memberApi.checkAuth()");
        return null;
    }

    /**
     * 登录
     */
    public AuthSession login(String mobile, String password, boolean isKeepSignedIn) {
        RemoteApiResponse <com.gcbi.gcuser.model.AuthSession> resp = authApi.login(mobile, password, isKeepSignedIn);
        if (resp.isSuccess()) {
            if (resp.getData() == null) {
                return null;
            }
            AuthSession retSession = new AuthSession();
            BeanUtils.copyProperties(resp.getData(), retSession);
            return retSession;
        }
        handleErrorResp(resp, "memberApi.checkAuth()");
        return null;
    }

    /**
     * 退出
     */
    public void logout(String authId) {
        RemoteApiResponse <Object> resp = authApi.logout(authId);
        if (resp.isSuccess()) {
            return;
        }
        handleErrorResp(resp, "memberApi.checkAuth()");
        return;
    }

}
