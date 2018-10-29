package com.philips.h2h.bama.app.identification.domain.model;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class SailorModel {

    //fields
    private String name;
    private String genderCode;
    private String sailorId;

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

    public String getSailorId() {
        return sailorId;
    }

    public void setSailorId(String sailorId) {
        this.sailorId = sailorId;
    }
}
