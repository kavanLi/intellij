package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.BarberRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Barber;
import com.philips.h2h.bama.app.identification.service.atom.BarberService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class BarberServiceImpl implements BarberService {

    //fields
    @Autowired
    private BarberRepository barberRepository;

    /**
     * save barber
     *
     * @param barber barber info
     * @return saved barber
     */
    @Override
    public Optional <Barber> saveBarber(@NotNull Barber barber) {
        return barberRepository.softlySave(barber);
    }

    /**
     * find a barber by oid
     *
     * @param barberOid targe barber oid
     * @return barber or null
     */
    @Override
    public Optional <Barber> findBarberById(@NotNull Long barberOid) {
        Barber barber = barberRepository.findOne(barberOid);
        return Optional.ofNullable(barber);
    }

    /**
     * delete target barber info
     *
     * @param barberOid target barber oid
     */
    @Override
    public void deleteBarberByID(@NotNull Long barberOid) {
        barberRepository.softlyDelete(barberOid);
    }

}
