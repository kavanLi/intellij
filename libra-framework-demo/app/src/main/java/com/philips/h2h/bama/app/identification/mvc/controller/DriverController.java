package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Driver;
import com.philips.h2h.bama.app.identification.domain.model.DriverModel;
import com.philips.h2h.bama.app.identification.service.atom.DriverService;
import com.philips.h2h.bama.app.identification.service.business.DriverBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for driver service
@RestController
@RequestMapping("/drivers")
public class DriverController {

    //fields
    @Autowired
    private DriverBizService driverBizService;

    @Autowired
    private DriverService driverService;

    //public methods

    /**
     * show a driver for details
     *
     * @param driverOid target driver oid
     * @return driver info
     */
    @RequestMapping(value = "/{driverOid}")
    public DriverModel getShow(@PathVariable Long driverOid) {
        DriverModel driverModel = driverBizService.findDriver(driverOid);
        return driverModel;
    }

    /**
     * create a driver
     *
     * @param model driver info
     * @return saved driver
     */
    @RequestMapping(method = RequestMethod.POST)
    public DriverModel postStore(@RequestBody Driver model) {
        DriverModel driverModel = driverBizService.createDriver(model);
        return driverModel;
    }

    /**
     * update driver
     *
     * @param driverOid target driver oid
     * @param model     update info
     * @return updated driver
     */
    @RequestMapping(value = "/{driverOid}", method = RequestMethod.PUT)
    public DriverModel Update(@PathVariable Long driverOid, @RequestBody Driver model) {
        model.setOid(driverOid);
        DriverModel driverModel = driverBizService.updateDriver(model);
        return driverModel;
    }

    /**
     * delete driver
     *
     * @param driverOid target driver oid
     */
    @RequestMapping(value = "/{driverOid}", method = RequestMethod.DELETE)
    public void deleteDriver(@PathVariable Long driverOid) {
        driverService.deleteDriverByID(driverOid);
    }
}
