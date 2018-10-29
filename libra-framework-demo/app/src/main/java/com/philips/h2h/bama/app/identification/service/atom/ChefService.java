package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Chef;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface ChefService {

    Optional <Chef> saveChef(@NotNull Chef chef);

    Optional <Chef> findChefById(@NotNull Long chefOid);

    void deleteChefByID(@NotNull Long chefOid);
}
