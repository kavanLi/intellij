package com.philips.h2h.bama.app.identification.domain.model;

import com.philips.h2h.bama.platform.core.domain.model.common.BaseModel;

/**
 * Created by Ritchie on 9/22/2017.
 */
// officer model
public class OfficerModel extends BaseModel {
    //field
    private String name;
    private String gerderCode;
    private String ethnicCode;
    private String idNo;
    private String officerId;
    private String inofficerId;
    private String outofficerId;
    private String securityId;
    //getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGerderCode() {
        return gerderCode;
    }

    public void setGerderCode(String gerderCode) {
        this.gerderCode = gerderCode;
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
}
