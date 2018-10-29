package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Archer;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface ArcherService {

    Optional <Archer> saveArcher(@NotNull Archer archer);

    Optional <Archer> findArcherById(@NotNull Long archerOid);

    void deleteArcherByID(@NotNull Long archerOid);
}
