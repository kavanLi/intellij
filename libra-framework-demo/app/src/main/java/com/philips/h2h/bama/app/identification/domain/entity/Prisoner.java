package com.philips.h2h.bama.app.identification.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.philips.h2h.bama.platform.core.domain.entity.BusinessEntity;

/**
 * Created by Ritchie on 9/24/2017.
 */
@Entity
@Table(name = "t_identification_prisoner")
public class Prisoner extends BusinessEntity {

    //fields

    @Column(name = "name", length = 256)
    private String name;
    @Column(name = "gender_code", length = 8)
    private String genderCode;
    @Column(name = "prisoner_id", length = 256)
    private String prisonerId;

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

    public String getPrisonerId() {
        return prisonerId;
    }

    public void setPrisonerId(String prisonerId) {
        this.prisonerId = prisonerId;
    }
}
