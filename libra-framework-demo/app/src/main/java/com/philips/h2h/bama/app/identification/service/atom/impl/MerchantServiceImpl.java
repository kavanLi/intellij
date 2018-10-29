package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.MerchantRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Merchant;
import com.philips.h2h.bama.app.identification.service.atom.MerchantService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class MerchantServiceImpl implements MerchantService {

    //fields
    @Autowired
    private MerchantRepository merchantRepository;

    /**
     * save merchant
     *
     * @param merchant merchant info
     * @return saved merchant
     */
    @Override
    public Optional <Merchant> saveMerchant(@NotNull Merchant merchant) {
        return merchantRepository.softlySave(merchant);
    }

    /**
     * find a merchant by oid
     *
     * @param merchantOid targe merchant oid
     * @return merchant or null
     */
    @Override
    public Optional <Merchant> findMerchantById(@NotNull Long merchantOid) {
        Merchant merchant = merchantRepository.findOne(merchantOid);
        return Optional.ofNullable(merchant);
    }

    /**
     * delete target merchant info
     *
     * @param merchantOid target merchant oid
     */
    @Override
    public void deleteMerchantByID(@NotNull Long merchantOid) {
        merchantRepository.softlyDelete(merchantOid);
    }

}
