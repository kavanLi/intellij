package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Barber;
import com.philips.h2h.bama.app.identification.domain.model.BarberModel;
import com.philips.h2h.bama.app.identification.exception.InactiveBarberModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundBarberException;
import com.philips.h2h.bama.app.identification.service.atom.BarberService;
import com.philips.h2h.bama.app.identification.service.business.BarberBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class BarberBizServiceImpl implements BarberBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(BarberBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private BarberService barberService;

    //public methods

    /**
     * create a barber
     *
     * @param model barber info
     * @return saved barber
     */
    @Override
    public BarberModel createBarber(@NotNull Barber model) {
        //biz logical codes go here and use atom service to save it
        Optional <Barber> barberOptional = barberService.saveBarber(model);
        return barberOptional.isPresent() ? beenMapper.map(barberOptional.get(), BarberModel.class) : null;
    }

    /**
     * use model to updateBarber
     *
     * @param model target
     * @return updated barber
     */
    @Override
    public BarberModel updateBarber(@NotNull Barber model) {
        Long barberOid = model.getOid();
        Barber barber;
        Optional <Barber> barberOptional = barberService.findBarberById(barberOid);
        if (barberOptional.isPresent()) {
            barber = barberOptional.get();
            //case 1: if target barber is inactive, we cannot modify it and throw a system exception
            if (!barber.getActive()) {
                throw new InactiveBarberModificationException("inactive barber,deny modifying");
            }
            //biz logic codes go here
            barber.setName(model.getName());
            barber.setGenderCode(model.getGenderCode());
            barber.setBarberId(model.getBarberId());
            Optional <Barber> barberOptional1 = barberService.saveBarber(barber);
        } else {
            //case 2:if not found target barber,throw a biz exception
            logger.debug("not found target", model, barberOid);
            throw new NotFoundBarberException("not found, can do anyting");
        }
        return barberOptional.isPresent() ? beenMapper.map(barberOptional.get(), BarberModel.class) : null;
    }

    /**
     * findBarber by barberOid
     *
     * @param barberOid target oid
     * @return barber details
     */
    @Override
    public BarberModel findBarber(@NotNull Long barberOid) {
        Optional <Barber> barberOptional = barberService.findBarberById(barberOid);
        return barberOptional.isPresent() ? beenMapper.map(barberOptional.get(), BarberModel.class) : null;
    }
}
