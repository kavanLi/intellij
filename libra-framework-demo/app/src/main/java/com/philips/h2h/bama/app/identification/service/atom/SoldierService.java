package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Soldier;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface SoldierService {

    Optional <Soldier> saveSoldier(@NotNull Soldier soldier);

    Optional <Soldier> findSoldierById(@NotNull Long soldierOid);

    void deleteSoldierByID(@NotNull Long soldierOid);
}
