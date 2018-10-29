package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Priest;
import com.philips.h2h.bama.app.identification.domain.model.PriestModel;
import com.philips.h2h.bama.app.identification.service.atom.PriestService;
import com.philips.h2h.bama.app.identification.service.business.PriestBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for priest service
@RestController
@RequestMapping("/priests")
public class PriestController {

    //fields
    @Autowired
    private PriestBizService priestBizService;

    @Autowired
    private PriestService priestService;

    //public methods

    /**
     * show a priest for details
     *
     * @param priestOid target priest oid
     * @return priest info
     */
    @RequestMapping(value = "/{priestOid}")
    public PriestModel getShow(@PathVariable Long priestOid) {
        PriestModel priestModel = priestBizService.findPriest(priestOid);
        return priestModel;
    }

    /**
     * create a priest
     *
     * @param model priest info
     * @return saved priest
     */
    @RequestMapping(method = RequestMethod.POST)
    public PriestModel postStore(@RequestBody Priest model) {
        PriestModel priestModel = priestBizService.createPriest(model);
        return priestModel;
    }

    /**
     * update priest
     *
     * @param priestOid target priest oid
     * @param model     update info
     * @return updated priest
     */
    @RequestMapping(value = "/{priestOid}", method = RequestMethod.PUT)
    public PriestModel Update(@PathVariable Long priestOid, @RequestBody Priest model) {
        model.setOid(priestOid);
        PriestModel priestModel = priestBizService.updatePriest(model);
        return priestModel;
    }

    /**
     * delete priest
     *
     * @param priestOid target priest oid
     */
    @RequestMapping(value = "/{priestOid}", method = RequestMethod.DELETE)
    public void deletePriest(@PathVariable Long priestOid) {
        priestService.deletePriestByID(priestOid);
    }
}
