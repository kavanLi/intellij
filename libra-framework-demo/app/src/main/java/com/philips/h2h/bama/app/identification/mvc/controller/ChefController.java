package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Chef;
import com.philips.h2h.bama.app.identification.domain.model.ChefModel;
import com.philips.h2h.bama.app.identification.service.atom.ChefService;
import com.philips.h2h.bama.app.identification.service.business.ChefBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for chef service
@RestController
@RequestMapping("/chefs")
public class ChefController {

    //fields
    @Autowired
    private ChefBizService chefBizService;

    @Autowired
    private ChefService chefService;

    //public methods

    /**
     * show a chef for details
     *
     * @param chefOid target chef oid
     * @return chef info
     */
    @RequestMapping(value = "/{chefOid}")
    public ChefModel getShow(@PathVariable Long chefOid) {
        ChefModel chefModel = chefBizService.findChef(chefOid);
        return chefModel;
    }

    /**
     * create a chef
     *
     * @param model chef info
     * @return saved chef
     */
    @RequestMapping(method = RequestMethod.POST)
    public ChefModel postStore(@RequestBody Chef model) {
        ChefModel chefModel = chefBizService.createChef(model);
        return chefModel;
    }

    /**
     * update chef
     *
     * @param chefOid target chef oid
     * @param model   update info
     * @return updated chef
     */
    @RequestMapping(value = "/{chefOid}", method = RequestMethod.PUT)
    public ChefModel Update(@PathVariable Long chefOid, @RequestBody Chef model) {
        model.setOid(chefOid);
        ChefModel chefModel = chefBizService.updateChef(model);
        return chefModel;
    }

    /**
     * delete chef
     *
     * @param chefOid target chef oid
     */
    @RequestMapping(value = "/{chefOid}", method = RequestMethod.DELETE)
    public void deleteChef(@PathVariable Long chefOid) {
        chefService.deleteChefByID(chefOid);
    }
}
