package com.gcbi.damo.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gcbi.cloud.common.core.utils.BeanCopyUtils;
import com.gcbi.damo.domain.AnnotationTransactionDto;
import com.gcbi.damo.domain.HtmlStringDto;
import com.gcbi.damo.rpt.AnnotationTransactionMapper;
import com.gcbi.damo.rpt.eo.AnnotationEO;
import com.gcbi.damo.rpt.eo.AnnotationTransactionEo;
import com.gcbi.damo.rpt.eo.HtmlStringEo;

@Service
@Transactional
public class AnnotionTranService {

    @Autowired
    AnnotationTransactionMapper annotationTransactionMapper;

    @Autowired
    AnnotationService annotationService;

    @Autowired
    HtmlStringService htmlStringService;

    public AnnotationTransactionDto findone(AnnotationTransactionEo eo) {
        AnnotationTransactionEo findone = annotationTransactionMapper.findone(eo);
        AnnotationTransactionDto copyEO2Bean = BeanCopyUtils.copyEO2Bean(findone, AnnotationTransactionDto.class);
        return copyEO2Bean;
    }

    @Transactional
    public void saveAnnotation(Integer label, Long htmlId, String subType) {
        Assert.notNull(htmlId, "htmlId is must be null");
        Assert.notNull(label, "label is must be null");
        HtmlStringDto stringEo = htmlStringService.selectById(htmlId);
        Assert.notNull(stringEo, "HtmlStringEo is must be null");
        if (label == 0 || label == 1 || label == 2 || label == null) {
            AnnotationTransactionEo eo = new AnnotationTransactionEo();
            eo.setInsertDate(new Date());
            eo.setLabel(label);
            eo.setRelId(stringEo.getRelId());
            eo.setUserId(stringEo.getUserId());
            eo.setBatchId(stringEo.getBatchId());
            eo.setSubType(subType);
            annotationTransactionMapper.addannotation(eo);
            htmlStringService.updateHtmlString(htmlId, label, subType);
        } else {
            throw new RuntimeException("label not match");
        }
    }

    //@Transactional
    //public void saveSubType(String subType, Long htmlId) {
    //	Assert.notNull(subType, "subType is null");
    //	Assert.notNull(htmlId, "htmlId is must be null");
    //	if (StringUtils.isNotEmpty(subType)) {
    //		htmlStringService.updateHtmlStringSubType(htmlId, subType);
    //	} else {
    //		throw new RuntimeException("subType not match");
    //	}
    //}
}
