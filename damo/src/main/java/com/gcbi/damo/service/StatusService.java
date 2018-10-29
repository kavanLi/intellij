package com.gcbi.damo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gcbi.cloud.common.core.utils.BeanCopyUtils;
import com.gcbi.damo.domain.StatusDto;
import com.gcbi.damo.rpt.StatusMapper;
import com.gcbi.damo.rpt.eo.StatusEo;

@Service
@Transactional
public class StatusService {

    @Autowired
    StatusMapper statusMapper;

    public StatusDto findone() {
        StatusEo eo = statusMapper.findone();
        return BeanCopyUtils.copyEO2Bean(eo, StatusDto.class);
    }


    public void updateStauts(StatusEo eo) {

        statusMapper.updateStatus(eo);
    }
}
