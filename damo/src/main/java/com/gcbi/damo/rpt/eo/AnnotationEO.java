package com.gcbi.damo.rpt.eo;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
/*@Entity
@Table(name="annotation")*/
public class AnnotationEO implements Serializable {

    //	@Id
//	@GeneratedValue(strategy=GenerationType .AUTO)
    Long id;
    Long relId;
    Long userId;
    Integer label;
    Integer batchId;

}
