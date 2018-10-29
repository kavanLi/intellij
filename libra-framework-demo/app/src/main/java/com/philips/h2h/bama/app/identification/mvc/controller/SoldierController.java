package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Soldier;
import com.philips.h2h.bama.app.identification.domain.model.SoldierModel;
import com.philips.h2h.bama.app.identification.service.atom.SoldierService;
import com.philips.h2h.bama.app.identification.service.business.SoldierBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for soldier service
@RestController
@RequestMapping("/soldiers")
public class SoldierController {

    //fields
    @Autowired
    private SoldierBizService soldierBizService;

    @Autowired
    private SoldierService soldierService;

    //public methods

    /**
     * show a soldier for details
     *
     * @param soldierOid target soldier oid
     * @return soldier info
     */
    @RequestMapping(value = "/{soldierOid}")
    public SoldierModel getShow(@PathVariable Long soldierOid) {
        SoldierModel soldierModel = soldierBizService.findSoldier(soldierOid);
        return soldierModel;
    }

    /**
     * create a soldier
     *
     * @param model soldier info
     * @return saved soldier
     */
    @RequestMapping(method = RequestMethod.POST)
    public SoldierModel postStore(@RequestBody Soldier model) {
        SoldierModel soldierModel = soldierBizService.createSoldier(model);
        return soldierModel;
    }

    /**
     * update soldier
     *
     * @param soldierOid target soldier oid
     * @param model      update info
     * @return updated soldier
     */
    @RequestMapping(value = "/{soldierOid}", method = RequestMethod.PUT)
    public SoldierModel Update(@PathVariable Long soldierOid, @RequestBody Soldier model) {
        model.setOid(soldierOid);
        SoldierModel soldierModel = soldierBizService.updateSoldier(model);
        return soldierModel;
    }

    /**
     * delete soldier
     *
     * @param soldierOid target soldier oid
     */
    @RequestMapping(value = "/{soldierOid}", method = RequestMethod.DELETE)
    public void deleteSoldier(@PathVariable Long soldierOid) {
        soldierService.deleteSoldierByID(soldierOid);
    }
}
