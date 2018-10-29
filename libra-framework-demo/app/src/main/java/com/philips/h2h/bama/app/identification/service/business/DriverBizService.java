package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Driver;
import com.philips.h2h.bama.app.identification.domain.model.DriverModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface DriverBizService {

    DriverModel createDriver(@NotNull Driver model);

    DriverModel updateDriver(@NotNull Driver model);

    DriverModel findDriver(@NotNull Long driverOid);
}
