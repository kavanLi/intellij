package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Merchant;
import com.philips.h2h.bama.app.identification.domain.model.MerchantModel;
import com.philips.h2h.bama.app.identification.exception.InactiveMerchantModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundMerchantException;
import com.philips.h2h.bama.app.identification.service.atom.MerchantService;
import com.philips.h2h.bama.app.identification.service.business.MerchantBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class MerchantBizServiceImpl implements MerchantBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(MerchantBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private MerchantService merchantService;

    //public methods

    /**
     * create a merchant
     *
     * @param model merchant info
     * @return saved merchant
     */
    @Override
    public MerchantModel createMerchant(@NotNull Merchant model) {
        //biz logical codes go here and use atom service to save it
        Optional <Merchant> merchantOptional = merchantService.saveMerchant(model);
        return merchantOptional.isPresent() ? beenMapper.map(merchantOptional.get(), MerchantModel.class) : null;
    }

    /**
     * use model to updateMerchant
     *
     * @param model target
     * @return updated merchant
     */
    @Override
    public MerchantModel updateMerchant(@NotNull Merchant model) {
        Long merchantOid = model.getOid();
        Merchant merchant;
        Optional <Merchant> merchantOptional = merchantService.findMerchantById(merchantOid);
        if (merchantOptional.isPresent()) {
            merchant = merchantOptional.get();
            //case 1: if target merchant is inactive, we cannot modify it and throw a system exception
            if (!merchant.getActive()) {
                throw new InactiveMerchantModificationException("inactive merchant,deny modifying");
            }
            //biz logic codes go here
            merchant.setName(model.getName());
            merchant.setGenderCode(model.getGenderCode());
            merchant.setMerchantId(model.getMerchantId());
            Optional <Merchant> merchantOptional1 = merchantService.saveMerchant(merchant);
        } else {
            //case 2:if not found target merchant,throw a biz exception
            logger.debug("not found target", model, merchantOid);
            throw new NotFoundMerchantException("not found, can do anyting");
        }
        return merchantOptional.isPresent() ? beenMapper.map(merchantOptional.get(), MerchantModel.class) : null;
    }

    /**
     * findMerchant by merchantOid
     *
     * @param merchantOid target oid
     * @return merchant details
     */
    @Override
    public MerchantModel findMerchant(@NotNull Long merchantOid) {
        Optional <Merchant> merchantOptional = merchantService.findMerchantById(merchantOid);
        return merchantOptional.isPresent() ? beenMapper.map(merchantOptional.get(), MerchantModel.class) : null;
    }
}
