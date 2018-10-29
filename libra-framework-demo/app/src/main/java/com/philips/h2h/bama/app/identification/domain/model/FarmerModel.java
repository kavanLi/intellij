package com.philips.h2h.bama.app.identification.domain.model;

import com.philips.h2h.bama.platform.core.domain.model.common.BaseModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class FarmerModel extends BaseModel {

    //fields

    private String name;
    private String genderCode;
    private String farmerId;

    //public methods


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

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }
}
