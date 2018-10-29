package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Warrior;
import com.philips.h2h.bama.app.identification.domain.model.WarriorModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface WarriorBizService {

    WarriorModel createWarrior(@NotNull Warrior model);

    WarriorModel updateWarrior(@NotNull Warrior model);

    WarriorModel findWarrior(@NotNull Long warriorOid);
}
