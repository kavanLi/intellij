package com.gcbi.damo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcbi.damo.domain.StatusDto;
import com.gcbi.damo.domain.UserDto;
import com.gcbi.damo.rpt.eo.StatusEo;

@Service
@Transactional
public class Task {

    @Autowired
    StatusService statusService;

    @Autowired
    HtmlStringService htmlStringService;

    @Autowired
    UserServicve userServicve;

    public void addResources(UserDto userdto) {
        //更新用户信息
        userServicve.updateOrSaveUser(userdto);
        StatusDto dto = statusService.findone();
        Long userId = Long.valueOf(userdto.getMemberId());
        //去html_String 中查询用户是否已有资源
        Integer count = htmlStringService.count(userId, dto.getBatchId());
        if (count == null || count == 0) {
            //分配资源
            htmlStringService.addSource(userId, dto.getEpochId(), dto.getBatchId());
            StatusEo eo = new StatusEo();
            eo.setBatchId(dto.getBatchId());
            eo.setEpochId(dto.getEpochId() + 1);
            //更新状态
            statusService.updateStauts(eo);
        }

    }

}
