/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.domain.model;

/**
 * Search criteria used to query patients.
 */
public class PatientSearchCriteriaModel {

    /* fields          ------------------------------------------------------*/

    private String name;
    private String genderCode;
    private String ethnicCode;
    private String idNo;

    private String patientId;
    private String inpatientId;
    private String outpatientId;
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

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getInpatientId() {
        return inpatientId;
    }

    public void setInpatientId(String inpatientId) {
        this.inpatientId = inpatientId;
    }

    public String getOutpatientId() {
        return outpatientId;
    }

    public void setOutpatientId(String outpatientId) {
        this.outpatientId = outpatientId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }
}
