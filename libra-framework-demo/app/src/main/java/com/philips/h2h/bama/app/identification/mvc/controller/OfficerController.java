package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Officer;
import com.philips.h2h.bama.app.identification.domain.model.OfficerModel;
import com.philips.h2h.bama.app.identification.service.atom.OfficerService;
import com.philips.h2h.bama.app.identification.service.business.OfficerBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for officer officer
@RestController
@RequestMapping("/officers")
public class OfficerController {

    //fields

    @Autowired
    private OfficerBizService officerBizService;

    @Autowired
    private OfficerService officerService;

    //public methods

    /**
     * show officer info
     *
     * @param officerOid target officer
     * @return detail info
     */
    @RequestMapping(value = "/{officerOid}")
    public OfficerModel getShow(@PathVariable Long officerOid) {
        OfficerModel officerModel = officerBizService.findOfficer(officerOid);
        return officerModel;
    }

    /**
     * create a officer detail info to store
     *
     * @param model detail info
     * @return officer oid
     */
    @RequestMapping(method = RequestMethod.POST)
    private Long postStore(@RequestBody Officer model) {
        OfficerModel officerModel = officerBizService.createOfficer(model);
        return officerModel.getOid();
    }

    /**
     * update officer info for detail
     *
     * @param officerOid target officer
     * @param model      detail info
     * @return target officer oid
     */
    @RequestMapping(value = "/{officerOid}", method = RequestMethod.PUT)
    private OfficerModel putUpdate(@PathVariable Long officerOid, @RequestBody Officer model) {
        model.setOid(officerOid);
        OfficerModel officerModel = officerBizService.updateOfficer(model);
        return officerModel;
    }

    /**
     * delete  a officer
     *
     * @param officerOid target officer
     */
    @RequestMapping(value = "/{officerOid}", method = RequestMethod.DELETE)
    public void deleteOfficer(@PathVariable Long officerOid) {
        officerService.deleteOfficer(officerOid);
    }
}
