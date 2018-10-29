package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Merchant;
import com.philips.h2h.bama.app.identification.domain.model.MerchantModel;
import com.philips.h2h.bama.app.identification.service.atom.MerchantService;
import com.philips.h2h.bama.app.identification.service.business.MerchantBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for merchant service
@RestController
@RequestMapping("/merchants")
public class MerchantController {

    //fields
    @Autowired
    private MerchantBizService merchantBizService;

    @Autowired
    private MerchantService merchantService;

    //public methods

    /**
     * show a merchant for details
     *
     * @param merchantOid target merchant oid
     * @return merchant info
     */
    @RequestMapping(value = "/{merchantOid}")
    public MerchantModel getShow(@PathVariable Long merchantOid) {
        MerchantModel merchantModel = merchantBizService.findMerchant(merchantOid);
        return merchantModel;
    }

    /**
     * create a merchant
     *
     * @param model merchant info
     * @return saved merchant
     */
    @RequestMapping(method = RequestMethod.POST)
    public MerchantModel postStore(@RequestBody Merchant model) {
        MerchantModel merchantModel = merchantBizService.createMerchant(model);
        return merchantModel;
    }

    /**
     * update merchant
     *
     * @param merchantOid target merchant oid
     * @param model       update info
     * @return updated merchant
     */
    @RequestMapping(value = "/{merchantOid}", method = RequestMethod.PUT)
    public MerchantModel Update(@PathVariable Long merchantOid, @RequestBody Merchant model) {
        model.setOid(merchantOid);
        MerchantModel merchantModel = merchantBizService.updateMerchant(model);
        return merchantModel;
    }

    /**
     * delete merchant
     *
     * @param merchantOid target merchant oid
     */
    @RequestMapping(value = "/{merchantOid}", method = RequestMethod.DELETE)
    public void deleteMerchant(@PathVariable Long merchantOid) {
        merchantService.deleteMerchantByID(merchantOid);
    }
}
