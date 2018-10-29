package com.philips.h2h.bama.app.identification.domain.model;

import com.philips.h2h.bama.platform.core.domain.model.common.BaseModel;

/**
 * Created by Ritchie on 9/22/2017.
 */
// student model
public class StudentModel extends BaseModel {
    //field
    private String name;
    private String genderCode;
    private String ethnicCode;
    private String idNo;
    private String studentId;
    private String instudentId;
    private String outstudentId;
    private String securityId;
    //getter and setter

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
}
