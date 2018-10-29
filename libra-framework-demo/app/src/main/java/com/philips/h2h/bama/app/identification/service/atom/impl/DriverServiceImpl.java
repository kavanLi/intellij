package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.DriverRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Driver;
import com.philips.h2h.bama.app.identification.service.atom.DriverService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class DriverServiceImpl implements DriverService {

    //fields
    @Autowired
    private DriverRepository driverRepository;

    /**
     * save driver
     *
     * @param driver driver info
     * @return saved driver
     */
    @Override
    public Optional <Driver> saveDriver(@NotNull Driver driver) {
        return driverRepository.softlySave(driver);
    }

    /**
     * find a driver by oid
     *
     * @param driverOid targe driver oid
     * @return driver or null
     */
    @Override
    public Optional <Driver> findDriverById(@NotNull Long driverOid) {
        Driver driver = driverRepository.findOne(driverOid);
        return Optional.ofNullable(driver);
    }

    /**
     * delete target driver info
     *
     * @param driverOid target driver oid
     */
    @Override
    public void deleteDriverByID(@NotNull Long driverOid) {
        driverRepository.softlyDelete(driverOid);
    }

}
