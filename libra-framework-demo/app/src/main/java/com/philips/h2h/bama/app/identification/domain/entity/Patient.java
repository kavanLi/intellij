/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.domain.entity;

import com.philips.h2h.bama.platform.core.domain.entity.BusinessEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Patient entity.
 */
@Entity
@Table(name = "t_identification_patient")
public class Patient extends BusinessEntity {

    /* fields ------------------------------------------------------ */

    @Column(name = "name", length = 64)
    private String name;
    @Column(name = "gender_code", length = 8)
    private String genderCode;
    @Column(name = "ethnic_code", length = 8)
    private String ethnicCode;
    @Column(name = "id_no", length = 64)
    private String idNo;

    @Column(name = "patient_id", length = 256)
    private String patientId;
    @Column(name = "inpatient_id", length = 256)
    private String inpatientId;
    @Column(name = "outpatient_id", length = 256)
    private String outpatientId;
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

    public String getOtherId() {
        return otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }
}
