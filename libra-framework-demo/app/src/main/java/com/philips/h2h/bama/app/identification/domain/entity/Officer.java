package com.philips.h2h.bama.app.identification.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.philips.h2h.bama.platform.core.domain.entity.BusinessEntity;

/**
 * Created by Ritchie on 9/22/2017.
 */
//officer entity
@Entity
@Table(name = "t_identification_officer")
public class Officer extends BusinessEntity {
    //field
    @Column(name = "name", length = 64)
    private String name;
    @Column(name = "gender_code", length = 8)
    private String genderCode;
    @Column(name = "ethnic_code", length = 8)
    private String ethnicCode;
    @Column(name = "id_no", length = 64)
    private String idNo;

    @Column(name = "officer_id", length = 256)
    private String officerId;
    @Column(name = "inofficer_id", length = 256)
    private String inofficerId;
    @Column(name = "outofficer_id", length = 256)
    private String outofficerId;
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

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getInofficerId() {
        return inofficerId;
    }

    public void setInofficerId(String inofficerId) {
        this.inofficerId = inofficerId;
    }

    public String getOutofficerId() {
        return outofficerId;
    }

    public void setOutofficerId(String outofficerId) {
        this.outofficerId = outofficerId;
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
