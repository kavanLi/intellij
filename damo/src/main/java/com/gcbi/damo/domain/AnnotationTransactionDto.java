package com.gcbi.damo.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class AnnotationTransactionDto implements Serializable {
    Long id;
    Long relId;
    Long userId;
    Integer label;
    Long batchId;
    Date insertDate;
}