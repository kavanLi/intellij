package com.gcbi.damo.rpt.eo;

import java.io.Serializable;

import lombok.Data;

@Data
public class StatusEo implements Serializable {

    private Long batchId;

    private Long epochId;

}
