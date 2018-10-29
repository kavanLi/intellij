package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Warrior;
import com.philips.h2h.bama.app.identification.domain.model.WarriorModel;
import com.philips.h2h.bama.app.identification.service.atom.WarriorService;
import com.philips.h2h.bama.app.identification.service.business.WarriorBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for warrior service
@RestController
@RequestMapping("/warriors")
public class WarriorController {

    //fields
    @Autowired
    private WarriorBizService warriorBizService;

    @Autowired
    private WarriorService warriorService;

    //public methods

    /**
     * show a warrior for details
     *
     * @param warriorOid target warrior oid
     * @return warrior info
     */
    @RequestMapping(value = "/{warriorOid}")
    public WarriorModel getShow(@PathVariable Long warriorOid) {
        WarriorModel warriorModel = warriorBizService.findWarrior(warriorOid);
        return warriorModel;
    }

    /**
     * create a warrior
     *
     * @param model warrior info
     * @return saved warrior
     */
    @RequestMapping(method = RequestMethod.POST)
    public WarriorModel postStore(@RequestBody Warrior model) {
        WarriorModel warriorModel = warriorBizService.createWarrior(model);
        return warriorModel;
    }

    /**
     * update warrior
     *
     * @param warriorOid target warrior oid
     * @param model      update info
     * @return updated warrior
     */
    @RequestMapping(value = "/{warriorOid}", method = RequestMethod.PUT)
    public WarriorModel Update(@PathVariable Long warriorOid, @RequestBody Warrior model) {
        model.setOid(warriorOid);
        WarriorModel warriorModel = warriorBizService.updateWarrior(model);
        return warriorModel;
    }

    /**
     * delete warrior
     *
     * @param warriorOid target warrior oid
     */
    @RequestMapping(value = "/{warriorOid}", method = RequestMethod.DELETE)
    public void deleteWarrior(@PathVariable Long warriorOid) {
        warriorService.deleteWarriorByID(warriorOid);
    }
}
