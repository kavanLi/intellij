package com.gcbi.damo.domain;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class HtmlStringDto implements Serializable {
    private Long id;
    private Long relId;
    private String html;
    private String relType;
    private String subType;
    private String translation;
    private Long userId;
    private Long batchId;
    private Integer label;
    private String relTypeTranslation;
}