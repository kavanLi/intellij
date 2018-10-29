package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Sailor;
import com.philips.h2h.bama.app.identification.domain.model.SailorModel;
import com.philips.h2h.bama.app.identification.service.atom.SailorService;
import com.philips.h2h.bama.app.identification.service.business.SailorBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for sailor service
@RestController
@RequestMapping("/sailors")
public class SailorController {

    //fields
    @Autowired
    private SailorBizService sailorBizService;

    @Autowired
    private SailorService sailorService;

    //public methods

    /**
     * show a sailor for details
     *
     * @param sailorOid target sailor oid
     * @return sailor info
     */
    @RequestMapping(value = "/{sailorOid}")
    public SailorModel getShow(@PathVariable Long sailorOid) {
        SailorModel sailorModel = sailorBizService.findSailor(sailorOid);
        return sailorModel;
    }

    /**
     * create a sailor
     *
     * @param model sailor info
     * @return saved sailor
     */
    @RequestMapping(method = RequestMethod.POST)
    public SailorModel postStore(@RequestBody Sailor model) {
        SailorModel sailorModel = sailorBizService.createSailor(model);
        return sailorModel;
    }

    /**
     * update sailor
     *
     * @param sailorOid target sailor oid
     * @param model     update info
     * @return updated sailor
     */
    @RequestMapping(value = "/{sailorOid}", method = RequestMethod.PUT)
    public SailorModel Update(@PathVariable Long sailorOid, @RequestBody Sailor model) {
        model.setOid(sailorOid);
        SailorModel sailorModel = sailorBizService.updateSailor(model);
        return sailorModel;
    }

    /**
     * delete sailor
     *
     * @param sailorOid target sailor oid
     */
    @RequestMapping(value = "/{sailorOid}", method = RequestMethod.DELETE)
    public void deleteSailor(@PathVariable Long sailorOid) {
        sailorService.deleteSailorByID(sailorOid);
    }
}
