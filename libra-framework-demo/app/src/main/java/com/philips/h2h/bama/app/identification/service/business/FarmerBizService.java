
package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Farmer;
import com.philips.h2h.bama.app.identification.domain.model.FarmerModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface FarmerBizService {

    FarmerModel createFarmer(@NotNull Farmer model);

    FarmerModel updateFarmer(@NotNull Farmer model);

    FarmerModel findFarmer(@NotNull Long farmerOid);
}
