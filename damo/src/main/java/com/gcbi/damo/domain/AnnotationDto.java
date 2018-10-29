package com.gcbi.damo.domain;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class AnnotationDto implements Serializable {

    Long id;
    Long relId;
    Long userId;
    Integer label;
    Integer batchId;

}