package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Driver;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface DriverService {

    Optional <Driver> saveDriver(@NotNull Driver driver);

    Optional <Driver> findDriverById(@NotNull Long driverOid);

    void deleteDriverByID(@NotNull Long driverOid);
}
