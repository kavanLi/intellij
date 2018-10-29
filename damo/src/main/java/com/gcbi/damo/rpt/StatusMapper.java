package com.gcbi.damo.rpt;

import org.apache.ibatis.annotations.Mapper;

import com.gcbi.damo.rpt.eo.StatusEo;

@Mapper
public interface StatusMapper {

    public StatusEo findone();

    public void updateStatus(StatusEo eo);

}
