package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Guard;
import com.philips.h2h.bama.app.identification.domain.model.GuardModel;
import com.philips.h2h.bama.app.identification.service.atom.GuardService;
import com.philips.h2h.bama.app.identification.service.business.GuardBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for guard service
@RestController
@RequestMapping("/guards")
public class GuardController {

    //fields
    @Autowired
    private GuardBizService guardBizService;

    @Autowired
    private GuardService guardService;

    //public methods

    /**
     * show a guard for details
     *
     * @param guardOid target guard oid
     * @return guard info
     */
    @RequestMapping(value = "/{guardOid}")
    public GuardModel getShow(@PathVariable Long guardOid) {
        GuardModel guardModel = guardBizService.findGuard(guardOid);
        return guardModel;
    }

    /**
     * create a guard
     *
     * @param model guard info
     * @return saved guard
     */
    @RequestMapping(method = RequestMethod.POST)
    public GuardModel postStore(@RequestBody Guard model) {
        GuardModel guardModel = guardBizService.createGuard(model);
        return guardModel;
    }

    /**
     * update guard
     *
     * @param guardOid target guard oid
     * @param model    update info
     * @return updated guard
     */
    @RequestMapping(value = "/{guardOid}", method = RequestMethod.PUT)
    public GuardModel Update(@PathVariable Long guardOid, @RequestBody Guard model) {
        model.setOid(guardOid);
        GuardModel guardModel = guardBizService.updateGuard(model);
        return guardModel;
    }

    /**
     * delete guard
     *
     * @param guardOid target guard oid
     */
    @RequestMapping(value = "/{guardOid}", method = RequestMethod.DELETE)
    public void deleteGuard(@PathVariable Long guardOid) {
        guardService.deleteGuardByID(guardOid);
    }
}
