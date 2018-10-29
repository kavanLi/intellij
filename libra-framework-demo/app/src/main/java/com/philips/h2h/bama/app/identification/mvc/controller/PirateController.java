package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Pirate;
import com.philips.h2h.bama.app.identification.domain.model.PirateModel;
import com.philips.h2h.bama.app.identification.service.atom.PirateService;
import com.philips.h2h.bama.app.identification.service.business.PirateBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for pirate service
@RestController
@RequestMapping("/pirates")
public class PirateController {

    //fields
    @Autowired
    private PirateBizService pirateBizService;

    @Autowired
    private PirateService pirateService;

    //public methods

    /**
     * show a pirate for details
     *
     * @param pirateOid target pirate oid
     * @return pirate info
     */
    @RequestMapping(value = "/{pirateOid}")
    public PirateModel getShow(@PathVariable Long pirateOid) {
        PirateModel pirateModel = pirateBizService.findPirate(pirateOid);
        return pirateModel;
    }

    /**
     * create a pirate
     *
     * @param model pirate info
     * @return saved pirate
     */
    @RequestMapping(method = RequestMethod.POST)
    public PirateModel postStore(@RequestBody Pirate model) {
        PirateModel pirateModel = pirateBizService.createPirate(model);
        return pirateModel;
    }

    /**
     * update pirate
     *
     * @param pirateOid target pirate oid
     * @param model     update info
     * @return updated pirate
     */
    @RequestMapping(value = "/{pirateOid}", method = RequestMethod.PUT)
    public PirateModel Update(@PathVariable Long pirateOid, @RequestBody Pirate model) {
        model.setOid(pirateOid);
        PirateModel pirateModel = pirateBizService.updatePirate(model);
        return pirateModel;
    }

    /**
     * delete pirate
     *
     * @param pirateOid target pirate oid
     */
    @RequestMapping(value = "/{pirateOid}", method = RequestMethod.DELETE)
    public void deletePirate(@PathVariable Long pirateOid) {
        pirateService.deletePirateByID(pirateOid);
    }
}
