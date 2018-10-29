package com.gcbi.damo.domain;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class QueryParameters implements Serializable {

    Long batchId;
    Long userId;
    //islabel 为null 查出所有
    //islabel为 true已标记
    //islabel 为false 未标记
    Boolean islabel;
    //当前页
    Integer pageNum;
    //每页展示
    Integer pageSize;
    Integer startNum;
}
