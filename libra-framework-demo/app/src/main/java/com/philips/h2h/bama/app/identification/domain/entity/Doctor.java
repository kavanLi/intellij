package com.philips.h2h.bama.app.identification.domain.entity;

/**
 * Created by Ritchie on 9/19/2017.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.philips.h2h.bama.platform.core.domain.entity.BusinessEntity;

//package com.philips.h2h.bama.app.identification.domain.entity;

/**
 * Doctor entity.
 */
@Entity
@Table(name = "t_identification_doctor")
public class Doctor extends BusinessEntity {

    /* fields ------------------------------------------------------ */

    @Column(name = "name", length = 64)
    private String name;
    @Column(name = "gender_code", length = 8)
    private String genderCode;
    @Column(name = "ethnic_code", length = 8)
    private String ethnicCode;
    @Column(name = "id_no", length = 64)

    private String idNo;

    @Column(name = "doctor_id", length = 256)
    private String doctorId;
    @Column(name = "indoctor_id", length = 256)
    private String indoctorId;
    @Column(name = "outdoctor_id", length = 256)
    private String outdoctorId;
    @Column(name = "security_id", length = 256)
    private String securityId;
    @Column(name = "other_id", length = 256)
    private String otherId;

    /* public methods ------------------------------------------------------ */

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

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getIndoctorId() {
        return indoctorId;
    }

    public void setIndoctorId(String indoctorId) {
        this.indoctorId = indoctorId;
    }

    public String getOutdoctortId() {
        return outdoctorId;
    }

    public void setOutdoctortId(String outdoctortId) {
        this.outdoctorId = outdoctortId;
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
