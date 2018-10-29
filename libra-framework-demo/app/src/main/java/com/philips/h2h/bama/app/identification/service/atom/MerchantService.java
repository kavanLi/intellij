package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Merchant;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface MerchantService {

    Optional <Merchant> saveMerchant(@NotNull Merchant merchant);

    Optional <Merchant> findMerchantById(@NotNull Long merchantOid);

    void deleteMerchantByID(@NotNull Long merchantOid);
}
