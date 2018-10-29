package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.PlumberRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Plumber;
import com.philips.h2h.bama.app.identification.service.atom.PlumberService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class PlumberServiceImpl implements PlumberService {

    //fields
    @Autowired
    private PlumberRepository plumberRepository;

    /**
     * save plumber
     *
     * @param plumber plumber info
     * @return saved plumber
     */
    @Override
    public Optional <Plumber> savePlumber(@NotNull Plumber plumber) {
        return plumberRepository.softlySave(plumber);
    }

    /**
     * find a plumber by oid
     *
     * @param plumberOid targe plumber oid
     * @return plumber or null
     */
    @Override
    public Optional <Plumber> findPlumberById(@NotNull Long plumberOid) {
        Plumber plumber = plumberRepository.findOne(plumberOid);
        return Optional.ofNullable(plumber);
    }

    /**
     * delete target plumber info
     *
     * @param plumberOid target plumber oid
     */
    @Override
    public void deletePlumberByID(@NotNull Long plumberOid) {
        plumberRepository.softlyDelete(plumberOid);
    }

}
