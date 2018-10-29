package com.gcbi.damo.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class StatusDto implements Serializable {

    private Long batchId;

    private Long epochId;

}
