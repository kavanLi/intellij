package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Warrior;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface WarriorService {

    Optional <Warrior> saveWarrior(@NotNull Warrior warrior);

    Optional <Warrior> findWarriorById(@NotNull Long warriorOid);

    void deleteWarriorByID(@NotNull Long warriorOid);
}
