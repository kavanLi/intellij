package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Prisoner;

/**
 * Created by Ritchie on 9/24/2017.
 */
@Validated
public interface PrisonerService {

    Optional <Prisoner> savePrisoner(@NotNull Prisoner prisoner);

    Optional <Prisoner> findPrisonerByID(@NotNull Long prisonerOid);

    void deletePrisonerById(@NotNull Long prisonerOid);
}
