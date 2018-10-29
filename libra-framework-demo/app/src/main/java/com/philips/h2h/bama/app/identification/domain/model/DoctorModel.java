package com.philips.h2h.bama.app.identification.domain.model;

import com.philips.h2h.bama.platform.core.domain.model.common.BaseModel;

/**
 * Created by Ritchie on 9/19/2017.
 */
public class DoctorModel extends BaseModel {
    /* fields          ------------------------------------------------------*/

    private String name;
    private String genderCode;
    private String indoctorId;

    private String ethnicCode;
    private String idNo;

    private String doctorId;
    private String outdoctorId;
    private String securityId;

    /* getters/setters ------------------------------------------------------*/

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

    public String getIndoctorId() {
        return indoctorId;
    }

    public void setIndoctorId(String indoctorId) {
        this.indoctorId = indoctorId;
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

    public String getOutdoctorId() {
        return outdoctorId;
    }

    public void setOutdoctorId(String outdoctorId) {
        this.outdoctorId = outdoctorId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }
}
