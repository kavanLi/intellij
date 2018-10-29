package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Farmer;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface FarmerService {

    Optional <Farmer> saveFarmer(@NotNull Farmer farmer);

    Optional <Farmer> findFarmerById(@NotNull Long farmerOid);

    void deleteFarmer(@NotNull Long farmerOid);

}
