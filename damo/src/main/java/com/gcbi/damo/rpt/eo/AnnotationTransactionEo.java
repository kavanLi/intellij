package com.gcbi.damo.rpt.eo;

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
//@Entity
//@Table(name="annotation_transaction")
@Data
public class AnnotationTransactionEo implements Serializable {

    //	@Id
//	@GeneratedValue(strategy=GenerationType .AUTO)
    Long id;
    Long relId;
    Long userId;
    Integer label;
    String subType;
    Long batchId;
    Date insertDate;
}
