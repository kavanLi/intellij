package com.gcbi.damo.rpt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gcbi.damo.domain.AddResouce;
import com.gcbi.damo.domain.QueryParameters;
import com.gcbi.damo.rpt.eo.HtmlStringEo;

@Mapper
public interface HtmlStringMapper {

    List <HtmlStringEo> findByUserIdAndBatchId(QueryParameters qarameters);

    List <Long> findAllBatchId(Long userId);

    Integer size(QueryParameters qarameters);

    void updateHtmlString(HtmlStringEo eo);

    HtmlStringEo selectById(Long htmlId);

    Integer count(HtmlStringEo eo);

    void addSource(AddResouce add);
}
