package com.gcbi.damo.domain;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class UserDto implements Serializable {
    private Long id;
    private String memberId;
    private String userName;
    private String remark;
}
