package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Plumber;
import com.philips.h2h.bama.app.identification.domain.model.PlumberModel;
import com.philips.h2h.bama.app.identification.exception.InactivePlumberModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundPlumberException;
import com.philips.h2h.bama.app.identification.service.atom.PlumberService;
import com.philips.h2h.bama.app.identification.service.business.PlumberBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class PlumberBizServiceImpl implements PlumberBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(PlumberBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private PlumberService plumberService;

    //public methods

    /**
     * create a plumber
     *
     * @param model plumber info
     * @return saved plumber
     */
    @Override
    public PlumberModel createPlumber(@NotNull Plumber model) {
        //biz logical codes go here and use atom service to save it
        Optional <Plumber> plumberOptional = plumberService.savePlumber(model);
        return plumberOptional.isPresent() ? beenMapper.map(plumberOptional.get(), PlumberModel.class) : null;
    }

    /**
     * use model to updatePlumber
     *
     * @param model target
     * @return updated plumber
     */
    @Override
    public PlumberModel updatePlumber(@NotNull Plumber model) {
        Long plumberOid = model.getOid();
        Plumber plumber;
        Optional <Plumber> plumberOptional = plumberService.findPlumberById(plumberOid);
        if (plumberOptional.isPresent()) {
            plumber = plumberOptional.get();
            //case 1: if target plumber is inactive, we cannot modify it and throw a system exception
            if (!plumber.getActive()) {
                throw new InactivePlumberModificationException("inactive plumber,deny modifying");
            }
            //biz logic codes go here
            plumber.setName(model.getName());
            plumber.setGenderCode(model.getGenderCode());
            plumber.setPlumberId(model.getPlumberId());
            Optional <Plumber> plumberOptional1 = plumberService.savePlumber(plumber);
        } else {
            //case 2:if not found target plumber,throw a biz exception
            logger.debug("not found target", model, plumberOid);
            throw new NotFoundPlumberException("not found, can do anyting");
        }
        return plumberOptional.isPresent() ? beenMapper.map(plumberOptional.get(), PlumberModel.class) : null;
    }

    /**
     * findPlumber by plumberOid
     *
     * @param plumberOid target oid
     * @return plumber details
     */
    @Override
    public PlumberModel findPlumber(@NotNull Long plumberOid) {
        Optional <Plumber> plumberOptional = plumberService.findPlumberById(plumberOid);
        return plumberOptional.isPresent() ? beenMapper.map(plumberOptional.get(), PlumberModel.class) : null;
    }
}
