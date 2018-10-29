package com.gcbi.damo.rpt;

import org.apache.ibatis.annotations.Mapper;

import com.gcbi.damo.rpt.eo.AnnotationTransactionEo;

@Mapper
public interface AnnotationTransactionMapper {

    public AnnotationTransactionEo findone(AnnotationTransactionEo eo);

    void addannotation(AnnotationTransactionEo eo);

    void updateannotation(AnnotationTransactionEo eo);
}
