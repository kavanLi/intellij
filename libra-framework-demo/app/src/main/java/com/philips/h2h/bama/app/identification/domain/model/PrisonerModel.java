package com.philips.h2h.bama.app.identification.domain.model;

/**
 * Created by Ritchie on 9/24/2017.
 */
public class PrisonerModel {

    //fields


    private String name;
    private String genderCode;
    private String prisonerId;

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

    public String getPrisonerId() {
        return prisonerId;
    }

    public void setPrisonerId(String prisonerId) {
        this.prisonerId = prisonerId;
    }
}
