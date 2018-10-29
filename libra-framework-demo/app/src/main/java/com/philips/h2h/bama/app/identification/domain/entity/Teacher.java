package com.philips.h2h.bama.app.identification.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.philips.h2h.bama.platform.core.domain.entity.BusinessEntity;

/**
 * Created by Ritchie on 9/22/2017.
 */
//teacher entity

@Entity
@Table(name = "t_identification_teacher")
public class Teacher extends BusinessEntity {
    //field
    @Column(name = "name", length = 64)
    private String name;
    @Column(name = "gender_code", length = 8)
    private String genderCode;
    @Column(name = "ethnic_code", length = 8)
    private String ethnicCode;
    @Column(name = "id_no", length = 64)
    private String idNo;

    @Column(name = "teacher_id", length = 256)
    private String teacherId;
    @Column(name = "inteacher_id", length = 256)
    private String inteacherId;
    @Column(name = "outteacher_id", length = 256)
    private String outteacherId;
    @Column(name = "security_id", length = 256)
    private String securityId;
    @Column(name = "other_id", length = 256)
    private String otherId;

    //public method

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

    public String getOtherId() {
        return otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }
}
