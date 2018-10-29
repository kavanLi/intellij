package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Barber;
import com.philips.h2h.bama.app.identification.domain.model.BarberModel;
import com.philips.h2h.bama.app.identification.service.atom.BarberService;
import com.philips.h2h.bama.app.identification.service.business.BarberBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for barber service
@RestController
@RequestMapping("/barbers")
public class BarberController {

    //fields
    @Autowired
    private BarberBizService barberBizService;

    @Autowired
    private BarberService barberService;

    //public methods

    /**
     * show a barber for details
     *
     * @param barberOid target barber oid
     * @return barber info
     */
    @RequestMapping(value = "/{barberOid}")
    public BarberModel getShow(@PathVariable Long barberOid) {
        BarberModel barberModel = barberBizService.findBarber(barberOid);
        return barberModel;
    }

    /**
     * create a barber
     *
     * @param model barber info
     * @return saved barber
     */
    @RequestMapping(method = RequestMethod.POST)
    public BarberModel postStore(@RequestBody Barber model) {
        BarberModel barberModel = barberBizService.createBarber(model);
        return barberModel;
    }

    /**
     * update barber
     *
     * @param barberOid target barber oid
     * @param model     update info
     * @return updated barber
     */
    @RequestMapping(value = "/{barberOid}", method = RequestMethod.PUT)
    public BarberModel Update(@PathVariable Long barberOid, @RequestBody Barber model) {
        model.setOid(barberOid);
        BarberModel barberModel = barberBizService.updateBarber(model);
        return barberModel;
    }

    /**
     * delete barber
     *
     * @param barberOid target barber oid
     */
    @RequestMapping(value = "/{barberOid}", method = RequestMethod.DELETE)
    public void deleteBarber(@PathVariable Long barberOid) {
        barberService.deleteBarberByID(barberOid);
    }
}
