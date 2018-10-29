package com.gcbi.damo.rpt.eo;

import java.io.Serializable;

import lombok.Data;

//@SuppressWarnings("serial")
@Data
//@Entity
//@Table(name="user")
public class UserEo implements Serializable {

    //	@Id
//	@GeneratedValue(strategy=GenerationType .AUTO)
    private Long id;
    private String memberId;
    private String userName;
    private String remark;

}
