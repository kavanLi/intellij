package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Pilot;
import com.philips.h2h.bama.app.identification.domain.model.PilotModel;
import com.philips.h2h.bama.app.identification.service.atom.PilotService;
import com.philips.h2h.bama.app.identification.service.business.PilotBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for pilot service
@RestController
@RequestMapping("/pilots")
public class PilotController {

    //fields
    @Autowired
    private PilotBizService pilotBizService;

    @Autowired
    private PilotService pilotService;

    //public methods

    /**
     * show a pilot for details
     *
     * @param pilotOid target pilot oid
     * @return pilot info
     */
    @RequestMapping(value = "/{pilotOid}")
    public PilotModel getShow(@PathVariable Long pilotOid) {
        PilotModel pilotModel = pilotBizService.findPilot(pilotOid);
        return pilotModel;
    }

    /**
     * create a pilot
     *
     * @param model pilot info
     * @return saved pilot
     */
    @RequestMapping(method = RequestMethod.POST)
    public PilotModel postStore(@RequestBody Pilot model) {
        PilotModel pilotModel = pilotBizService.createPilot(model);
        return pilotModel;
    }

    /**
     * update pilot
     *
     * @param pilotOid target pilot oid
     * @param model    update info
     * @return updated pilot
     */
    @RequestMapping(value = "/{pilotOid}", method = RequestMethod.PUT)
    public PilotModel Update(@PathVariable Long pilotOid, @RequestBody Pilot model) {
        model.setOid(pilotOid);
        PilotModel pilotModel = pilotBizService.updatePilot(model);
        return pilotModel;
    }

    /**
     * delete pilot
     *
     * @param pilotOid target pilot oid
     */
    @RequestMapping(value = "/{pilotOid}", method = RequestMethod.DELETE)
    public void deletePilot(@PathVariable Long pilotOid) {
        pilotService.deletePilotByID(pilotOid);
    }
}
