package com.gcbi.damo.cotroller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gcbi.cloud.common.core.auth.AuthUtils;
import com.gcbi.cloud.common.core.web.controller.AjaxControllerAnn;
import com.gcbi.cloud.common.model.auth.AuthSession;
import com.gcbi.cloud.common.model.base.GeneralResult;
import com.gcbi.damo.client.GcuserClient;
import com.gcbi.damo.domain.HtmlStringDto;
import com.gcbi.damo.domain.Page;
import com.gcbi.damo.domain.QueryParameters;
import com.gcbi.damo.domain.StatusDto;
import com.gcbi.damo.domain.UserDto;
import com.gcbi.damo.rpt.eo.AnnotationTransactionEo;
import com.gcbi.damo.rpt.eo.HtmlStringEo;
import com.gcbi.damo.service.AnnotionTranService;
import com.gcbi.damo.service.HtmlStringService;
import com.gcbi.damo.service.StatusService;
import com.gcbi.damo.service.Task;
import com.gcbi.damo.service.UserServicve;

@RestController
@AjaxControllerAnn
@RequestMapping("/ajax")
public class AjaxController {

    @Resource
    GcuserClient gcuserClient;

    @Resource(name = "commonExecutor")
    ThreadPoolTaskExecutor executor;

    @Resource
    UserServicve userServicve;

    @Resource
    HtmlStringService htmlStringService;

    @Resource
    AnnotionTranService annotionTranService;

    @Resource
    Task task;

    @Autowired
    StatusService statusService;

    //清露草木
    //登录
    @RequestMapping("/login")
    public GeneralResult <?> login(HttpServletRequest reuqest, HttpServletResponse respose, String username, String password) {
        AuthSession login = gcuserClient.login(username, password, true);
        AuthUtils.saveAuthId2Cookie(reuqest, respose, login.getAuthId());
        //异步同步到user表中,以及给用户分配资源
        executor.execute(() -> {
            UserDto dto = new UserDto();
            dto.setMemberId(String.valueOf(login.getMemberId()));
            dto.setUserName(login.getRealname());
            task.addResources(dto);
        });

        return GeneralResult.createSuccResult(login);
    }

    //登出
    @RequestMapping("/logout")
    public GeneralResult <?> logout(HttpServletRequest request, HttpServletResponse respose) {
        String authId = AuthUtils.getAuthId(request);
        gcuserClient.logout(authId);
        AuthUtils.clearAuthId(request, respose);
        return GeneralResult.createSuccResult();
    }

    //前端表格展示数据
    @RequestMapping("/htmllist")
    public GeneralResult <?> findHtmlListByUserId(QueryParameters param) {
        Page <HtmlStringDto> page = htmlStringService.findListByUserId(param);
        return GeneralResult.createSuccResult(page);
    }

    //修改数据
    @RequestMapping("/saveAnnotation")
    public GeneralResult <?> saveAnnotation(Integer label, Long htmlId, String subType) {
        annotionTranService.saveAnnotation(label, htmlId, subType);
        return GeneralResult.createSuccResult(null);
    }

    //获取所有批次
    @RequestMapping("/fetchBatch")
    public GeneralResult <?> fetchBatchIds(HttpServletRequest request) {
        AuthSession authSession = AuthUtils.getAuthSession(request);
        List <Long> list = htmlStringService.fetchBatchIds(Long.valueOf(authSession.getMemberId()));
        return GeneralResult.createSuccResult(list);
    }

    //获取当前批次
    @RequestMapping("/fetchCurrentBatch")
    public GeneralResult <?> fetchCurrentBatchId() {
        return GeneralResult.createSuccResult(statusService.findone());
    }
}
