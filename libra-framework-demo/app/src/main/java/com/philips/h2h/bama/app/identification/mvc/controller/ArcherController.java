package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Archer;
import com.philips.h2h.bama.app.identification.domain.model.ArcherModel;
import com.philips.h2h.bama.app.identification.service.atom.ArcherService;
import com.philips.h2h.bama.app.identification.service.business.ArcherBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for archer service
@RestController
@RequestMapping("/archers")
public class ArcherController {

    //fields
    @Autowired
    private ArcherBizService archerBizService;

    @Autowired
    private ArcherService archerService;

    //public methods

    /**
     * show a archer for details
     *
     * @param archerOid target archer oid
     * @return archer info
     */
    @RequestMapping(value = "/{archerOid}")
    public ArcherModel getShow(@PathVariable Long archerOid) {
        ArcherModel archerModel = archerBizService.findArcher(archerOid);
        return archerModel;
    }

    /**
     * create a archer
     *
     * @param model archer info
     * @return saved archer
     */
    @RequestMapping(method = RequestMethod.POST)
    public ArcherModel postStore(@RequestBody Archer model) {
        ArcherModel archerModel = archerBizService.createArcher(model);
        return archerModel;
    }

    /**
     * update archer
     *
     * @param archerOid target archer oid
     * @param model     update info
     * @return updated archer
     */
    @RequestMapping(value = "/{archerOid}", method = RequestMethod.PUT)
    public ArcherModel Update(@PathVariable Long archerOid, @RequestBody Archer model) {
        model.setOid(archerOid);
        ArcherModel archerModel = archerBizService.updateArcher(model);
        return archerModel;
    }

    /**
     * delete archer
     *
     * @param archerOid target archer oid
     */
    @RequestMapping(value = "/{archerOid}", method = RequestMethod.DELETE)
    public void deleteArcher(@PathVariable Long archerOid) {
        archerService.deleteArcherByID(archerOid);
    }
}
