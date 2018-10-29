package com.gcbi.damo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gcbi.cloud.common.core.utils.BeanCopyUtils;
import com.gcbi.damo.domain.AnnotationDto;
import com.gcbi.damo.rpt.AnnotationMapper;
import com.gcbi.damo.rpt.eo.AnnotationEO;


@Service
@Transactional
public class AnnotationService {

    @Autowired
    AnnotationMapper annotationMapper;


    public AnnotationDto findone(AnnotationEO eo) {
        AnnotationEO findone = annotationMapper.findone(eo);
        AnnotationDto copyEO2Bean = BeanCopyUtils.copyEO2Bean(findone, AnnotationDto.class);
        return copyEO2Bean;
    }


    public void updateOrSaveAnnotation(AnnotationEO eo) {
        Assert.notNull(eo, "annotation must be null");
        Assert.notNull(eo.getLabel(), "aannotation.lable is must be null");
        AnnotationDto findone = findone(eo);
        if (findone != null) {
            annotationMapper.updateannotation(eo);
        } else {
            annotationMapper.addannotation(eo);
        }


    }

}
