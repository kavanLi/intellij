package com.gcbi.damo.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcbi.cloud.common.core.utils.BeanCopyUtils;
import com.gcbi.damo.domain.AddResouce;
import com.gcbi.damo.domain.HtmlStringDto;
import com.gcbi.damo.domain.Page;
import com.gcbi.damo.domain.QueryParameters;
import com.gcbi.damo.rpt.HtmlStringMapper;
import com.gcbi.damo.rpt.eo.HtmlStringEo;

@Service
@Transactional
public class HtmlStringService {

    @Autowired
    HtmlStringMapper htmlStringMapper;

    /**
     * 获取所有批次列表
     *
     * @return
     */
    public List <Long> fetchBatchIds(Long userId) {
        List <Long> list = htmlStringMapper.findAllBatchId(userId);
        return list;
    }

    /**
     *
     */
    public void updateHtmlString(Long id, Integer label, String subType) {
        HtmlStringEo eo = new HtmlStringEo();
        eo.setId(id);
        eo.setLabel(label);
        eo.setSubType(subType);
        htmlStringMapper.updateHtmlString(eo);
    }

    /**
     * 获取每个人的列表
     * pageNum pageSize都不为null 支持分页
     * pageNum pageSize任意一个为null 不支持分页(查出所有符合条件的数据)
     */
    public Page <HtmlStringDto> findListByUserId(QueryParameters param) {
        Page <HtmlStringDto> page = null;
        if (param.getPageNum() != null && param.getPageSize() != null) {
            Integer size = htmlStringMapper.size(param);
            page = new Page <>(param.getPageNum(), size, param.getPageSize());
            param.setStartNum(page.getStartNum());
        }
        if (page != null && page.getTotalCount() == 0) {
            return page;
        }
        List <HtmlStringEo> list = htmlStringMapper.findByUserIdAndBatchId(param);
        List <HtmlStringDto> list2 = BeanCopyUtils.copyEO2BeanList(list, HtmlStringDto.class);
        if (page == null) {
            page = new Page <>();
        }
        page.setEntitys(list2);
        return page;
    }

    public HtmlStringDto selectById(Long htmlId) {
        HtmlStringEo eo = htmlStringMapper.selectById(htmlId);
        HtmlStringDto dto = BeanCopyUtils.copyEO2Bean(eo, HtmlStringDto.class);
        return dto;
    }


    public Integer count(Long userId, Long batchId) {
        HtmlStringEo eo = new HtmlStringEo();
        eo.setBatchId(batchId);
        eo.setUserId(userId);
        Integer count = htmlStringMapper.count(eo);
        return count;
    }


    public void addSource(Long userId, Long epochId, Long batchId) {
        AddResouce resouce = new AddResouce();
        resouce.setUserId(userId);
        resouce.setEpochId(epochId);
        resouce.setBatchId(batchId);
        htmlStringMapper.addSource(resouce);

    }
}
