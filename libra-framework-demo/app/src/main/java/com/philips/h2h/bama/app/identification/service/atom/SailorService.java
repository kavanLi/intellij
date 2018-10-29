package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Sailor;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface SailorService {

    Optional <Sailor> saveSailor(@NotNull Sailor sailor);

    Optional <Sailor> findSailorById(@NotNull Long sailorOid);

    void deleteSailorByID(@NotNull Long sailorOid);
}
