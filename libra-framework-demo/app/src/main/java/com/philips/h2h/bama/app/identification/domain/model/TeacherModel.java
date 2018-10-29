package com.philips.h2h.bama.app.identification.domain.model;

import com.philips.h2h.bama.platform.core.domain.model.common.BaseModel;

/**
 * Created by Ritchie on 9/22/2017.
 */
//teacher model
public class TeacherModel extends BaseModel {
    //field
    private String name;
    private String genderCode;
    private String ethnicCode;
    private String idNo;
    private String teacherId;
    private String inteacherId;
    private String outteacherId;
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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getInteacherId() {
        return inteacherId;
    }

    public void setInteacherId(String inteacherId) {
        this.inteacherId = inteacherId;
    }

    public String getOutteacherId() {
        return outteacherId;
    }

    public void setOutteacherId(String outteacherId) {
        this.outteacherId = outteacherId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }
}
