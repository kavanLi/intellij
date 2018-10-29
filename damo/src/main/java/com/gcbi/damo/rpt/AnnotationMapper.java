package com.gcbi.damo.rpt;

import org.apache.ibatis.annotations.Mapper;

import com.gcbi.damo.rpt.eo.AnnotationEO;

@Mapper
public interface AnnotationMapper {

    public AnnotationEO findone(AnnotationEO eo);

    void addannotation(AnnotationEO eo);

    void updateannotation(AnnotationEO eo);
}
