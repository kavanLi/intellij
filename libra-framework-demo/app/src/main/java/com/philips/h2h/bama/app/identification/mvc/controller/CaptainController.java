package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Captain;
import com.philips.h2h.bama.app.identification.domain.model.CaptainModel;
import com.philips.h2h.bama.app.identification.domain.model.ChefModel;
import com.philips.h2h.bama.app.identification.service.atom.CaptainService;
import com.philips.h2h.bama.app.identification.service.business.CaptainBizService;

/**
 * Created by Ritchie on 9/24/2017.
 */
@RestController
@RequestMapping(value = "/captains")
public class CaptainController {

    @Autowired
    private CaptainBizService captainBizService;

    @Autowired
    private CaptainService captainService;

    @RequestMapping(value = "/{captainOid}", method = RequestMethod.GET)
    public CaptainModel getShow(@PathVariable Long captainOid) {
        return captainBizService.findCaptain(captainOid);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CaptainModel postStore(@RequestBody Captain model) {
        return captainBizService.createCaptain(model);
    }

    @RequestMapping(value = "/{captainOid}", method = RequestMethod.PUT)
    public CaptainModel update(@PathVariable Long captainOid, @RequestBody Captain model) {
        model.setOid(captainOid);
        return captainBizService.updateCaptain(model);
    }

    @RequestMapping(value = "/{captainOid}", method = RequestMethod.DELETE)
    public void deleteCaptain(@PathVariable Long captainOid) {
        captainService.deleteCaptainById(captainOid);
    }
}
