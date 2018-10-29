package com.philips.h2h.bama.app.identification.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.philips.h2h.bama.platform.core.domain.entity.BusinessEntity;

/**
 * Created by Ritchie on 9/22/2017.
 */
// student entity
@Entity
@Table(name = "t_identification_student")
public class Student extends BusinessEntity {
    //fields
    @Column(name = "name", length = 64)
    private String name;
    @Column(name = "gender_code", length = 8)
    private String genderCode;
    @Column(name = "ethnic_code", length = 8)
    private String ethnicCode;
    @Column(name = "id_no", length = 64)
    private String idNo;

    @Column(name = "student_id", length = 256)
    private String studentId;
    @Column(name = "instudent_id", length = 256)
    private String instudentId;
    @Column(name = "outstudent_id", length = 256)
    private String outstudentId;
    @Column(name = "security_id", length = 256)
    private String securityId;
    @Column(name = "other_id", length = 256)
    private String otherId;

    //public methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getEthnicCode() {
        return ethnicCode;
    }

    public void setEthnicCode(String ethnicCode) {
        this.ethnicCode = ethnicCode;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getInstudentId() {
        return instudentId;
    }

    public void setInstudentId(String instudentId) {
        this.instudentId = instudentId;
    }

    public String getOutstudentId() {
        return outstudentId;
    }

    public void setOutstudentId(String outstudentId) {
        this.outstudentId = outstudentId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getOtherId() {
        return otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }
}
