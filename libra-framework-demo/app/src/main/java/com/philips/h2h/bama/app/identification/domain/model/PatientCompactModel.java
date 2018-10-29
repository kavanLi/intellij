/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.domain.model;

import com.philips.h2h.bama.platform.core.domain.model.common.BaseModel;

/**
 * Compact style of patient.
 */
public class PatientCompactModel extends BaseModel {

    /* fields          ------------------------------------------------------*/

    private String name;
    private String genderCode;
    private String inpatientId;

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

    public String getInpatientId() {
        return inpatientId;
    }

    public void setInpatientId(String inpatientId) {
        this.inpatientId = inpatientId;
    }
}
