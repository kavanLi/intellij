package com.philips.h2h.bama.app.identification.domain.model;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class PriestModel {

    //fields
    private String name;
    private String genderCode;
    private String priestId;

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

    public String getPriestId() {
        return priestId;
    }

    public void setPriestId(String priestId) {
        this.priestId = priestId;
    }
}
