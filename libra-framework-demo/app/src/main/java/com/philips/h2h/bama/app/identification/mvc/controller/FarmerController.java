package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Farmer;
import com.philips.h2h.bama.app.identification.domain.model.FarmerModel;
import com.philips.h2h.bama.app.identification.service.atom.FarmerService;
import com.philips.h2h.bama.app.identification.service.business.FarmerBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for farmer service
@RestController
@RequestMapping("/farmers")
public class FarmerController {

    //fields

    @Autowired
    private FarmerBizService farmerBizService;

    @Autowired
    private FarmerService farmerService;

    //public methods

    @RequestMapping(value = "/{farmerOid}")
    public FarmerModel getShow(@PathVariable Long farmerOid) {
        FarmerModel farmerModel = farmerBizService.findFarmer(farmerOid);
        return farmerModel;
    }

    @RequestMapping(method = RequestMethod.POST)
    public FarmerModel postStore(@RequestBody Farmer model) {
        FarmerModel farmerModel = farmerBizService.createFarmer(model);
        return farmerModel;
    }

    @RequestMapping(value = "/{farmerOid}", method = RequestMethod.PUT)
    public FarmerModel putUpdate(@PathVariable Long farmerOid, @RequestBody Farmer model) {
        model.setOid(farmerOid);
        FarmerModel farmerModel = farmerBizService.updateFarmer(model);
        return farmerModel;
    }

    @RequestMapping(value = "/{farmerOid}", method = RequestMethod.DELETE)
    public void deleteFarmer(@PathVariable Long farmerOid) {
        farmerService.deleteFarmer(farmerOid);
    }
}
