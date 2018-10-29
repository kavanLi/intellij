package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Plumber;
import com.philips.h2h.bama.app.identification.domain.model.PlumberModel;
import com.philips.h2h.bama.app.identification.service.atom.PlumberService;
import com.philips.h2h.bama.app.identification.service.business.PlumberBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for plumber service
@RestController
@RequestMapping("/plumbers")
public class PlumberController {

    //fields
    @Autowired
    private PlumberBizService plumberBizService;

    @Autowired
    private PlumberService plumberService;

    //public methods

    /**
     * show a plumber for details
     *
     * @param plumberOid target plumber oid
     * @return plumber info
     */
    @RequestMapping(value = "/{plumberOid}")
    public PlumberModel getShow(@PathVariable Long plumberOid) {
        PlumberModel plumberModel = plumberBizService.findPlumber(plumberOid);
        return plumberModel;
    }

    /**
     * create a plumber
     *
     * @param model plumber info
     * @return saved plumber
     */
    @RequestMapping(method = RequestMethod.POST)
    public PlumberModel postStore(@RequestBody Plumber model) {
        PlumberModel plumberModel = plumberBizService.createPlumber(model);
        return plumberModel;
    }

    /**
     * update plumber
     *
     * @param plumberOid target plumber oid
     * @param model      update info
     * @return updated plumber
     */
    @RequestMapping(value = "/{plumberOid}", method = RequestMethod.PUT)
    public PlumberModel Update(@PathVariable Long plumberOid, @RequestBody Plumber model) {
        model.setOid(plumberOid);
        PlumberModel plumberModel = plumberBizService.updatePlumber(model);
        return plumberModel;
    }

    /**
     * delete plumber
     *
     * @param plumberOid target plumber oid
     */
    @RequestMapping(value = "/{plumberOid}", method = RequestMethod.DELETE)
    public void deletePlumber(@PathVariable Long plumberOid) {
        plumberService.deletePlumberByID(plumberOid);
    }
}
