package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Chef;
import com.philips.h2h.bama.app.identification.domain.model.ChefModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface ChefBizService {

    ChefModel createChef(@NotNull Chef model);

    ChefModel updateChef(@NotNull Chef model);

    ChefModel findChef(@NotNull Long chefOid);
}
