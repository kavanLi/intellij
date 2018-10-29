package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Merchant;
import com.philips.h2h.bama.app.identification.domain.model.MerchantModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface MerchantBizService {

    MerchantModel createMerchant(@NotNull Merchant model);

    MerchantModel updateMerchant(@NotNull Merchant model);

    MerchantModel findMerchant(@NotNull Long merchantOid);
}
