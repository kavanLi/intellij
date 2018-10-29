package com.gcbi.damo.rpt.eo;

import java.io.Serializable;


import lombok.Data;

@SuppressWarnings("serial")
@Data
//@Entity
//@Table(name="html_string")
public class HtmlStringEo implements Serializable {

    //	@Id
//	@GeneratedValue(strategy=GenerationType .AUTO)
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


//	@OneToOne(cascade=CascadeType.REFRESH)
//	@JoinTable(
//	name="annotation",
//	joinColumns= {@JoinColumn(name="id",referencedColumnName="id")},
//	inverseJoinColumns= {@JoinColumn(name="htmlId")}
//	)
    //@ElementCollection
//	@CollectionTable(
//			name="annotation_htmlId",
//			joinColumns= {@JoinColumn(name="id",referencedColumnName="id")}
//			)
    //@CollectionTable(name="annotation")
    //AnnotationEO annotation;
}
