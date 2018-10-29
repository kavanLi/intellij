package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Driver;
import com.philips.h2h.bama.app.identification.domain.model.DriverModel;
import com.philips.h2h.bama.app.identification.exception.InactiveDriverModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundDriverException;
import com.philips.h2h.bama.app.identification.service.atom.DriverService;
import com.philips.h2h.bama.app.identification.service.business.DriverBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class DriverBizServiceImpl implements DriverBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(DriverBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private DriverService driverService;

    //public methods

    /**
     * create a driver
     *
     * @param model driver info
     * @return saved driver
     */
    @Override
    public DriverModel createDriver(@NotNull Driver model) {
        //biz logical codes go here and use atom service to save it
        Optional <Driver> driverOptional = driverService.saveDriver(model);
        return driverOptional.isPresent() ? beenMapper.map(driverOptional.get(), DriverModel.class) : null;
    }

    /**
     * use model to updateDriver
     *
     * @param model target
     * @return updated driver
     */
    @Override
    public DriverModel updateDriver(@NotNull Driver model) {
        Long driverOid = model.getOid();
        Driver driver;
        Optional <Driver> driverOptional = driverService.findDriverById(driverOid);
        if (driverOptional.isPresent()) {
            driver = driverOptional.get();
            //case 1: if target driver is inactive, we cannot modify it and throw a system exception
            if (!driver.getActive()) {
                throw new InactiveDriverModificationException("inactive driver,deny modifying");
            }
            //biz logic codes go here
            driver.setName(model.getName());
            driver.setGenderCode(model.getGenderCode());
            driver.setDriverId(model.getDriverId());
            Optional <Driver> driverOptional1 = driverService.saveDriver(driver);
        } else {
            //case 2:if not found target driver,throw a biz exception
            logger.debug("not found target", model, driverOid);
            throw new NotFoundDriverException("not found, can do anyting");
        }
        return driverOptional.isPresent() ? beenMapper.map(driverOptional.get(), DriverModel.class) : null;
    }

    /**
     * findDriver by driverOid
     *
     * @param driverOid target oid
     * @return driver details
     */
    @Override
    public DriverModel findDriver(@NotNull Long driverOid) {
        Optional <Driver> driverOptional = driverService.findDriverById(driverOid);
        return driverOptional.isPresent() ? beenMapper.map(driverOptional.get(), DriverModel.class) : null;
    }
}
