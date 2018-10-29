package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Soldier;
import com.philips.h2h.bama.app.identification.domain.model.SoldierModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface SoldierBizService {

    SoldierModel createSoldier(@NotNull Soldier model);

    SoldierModel updateSoldier(@NotNull Soldier model);

    SoldierModel findSoldier(@NotNull Long soldierOid);
}
