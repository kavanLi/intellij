package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Priest;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface PriestService {

    Optional <Priest> savePriest(@NotNull Priest priest);

    Optional <Priest> findPriestById(@NotNull Long priestOid);

    void deletePriestByID(@NotNull Long priestOid);
}
