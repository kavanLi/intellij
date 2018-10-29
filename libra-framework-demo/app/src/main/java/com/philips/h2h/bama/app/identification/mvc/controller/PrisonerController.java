package com.philips.h2h.bama.app.identification.mvc.controller;

import antlr.collections.impl.LList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Prisoner;
import com.philips.h2h.bama.app.identification.domain.model.PrisonerModel;
import com.philips.h2h.bama.app.identification.service.atom.PrisonerService;
import com.philips.h2h.bama.app.identification.service.business.PrisonerBizService;

/**
 * Created by Ritchie on 9/24/2017.
 */
//REST controller for Prisoner service
@RestController
@RequestMapping(value = "/prisoners")
public class PrisonerController {

    //fields

    @Autowired
    private PrisonerBizService prisonerBizService;

    @Autowired
    private PrisonerService prisonerService;

    //public service

    @RequestMapping(value = "/{prisonerOid}")
    public PrisonerModel getShow(@PathVariable Long prisonerOid) {
        return prisonerBizService.findPrisoner(prisonerOid);
    }

    @RequestMapping(method = RequestMethod.POST)
    public PrisonerModel postStore(@RequestBody Prisoner model) {
        return prisonerBizService.createPrisoner(model);
    }

    @RequestMapping(value = "/{prisonerOid}", method = RequestMethod.PUT)
    public PrisonerModel update(@PathVariable Long prisonerOid, @RequestBody Prisoner model) {
        model.setOid(prisonerOid);
        return prisonerBizService.updatePrisoner(model);
    }

    @RequestMapping(value = "/{prisonerOid}", method = RequestMethod.DELETE)
    public void deletePrisoner(@PathVariable Long prisonerOid) {
        prisonerService.deletePrisonerById(prisonerOid);
    }
}
