package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Archer;
import com.philips.h2h.bama.app.identification.domain.model.ArcherModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface ArcherBizService {

    ArcherModel createArcher(@NotNull Archer model);

    ArcherModel updateArcher(@NotNull Archer model);

    ArcherModel findArcher(@NotNull Long archerOid);
}
