/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.querer.libra.app.event.domain.model.EventModel;
import com.querer.libra.app.event.service.business.EventBizService;

@RestController
@RequestMapping("/events")
public class EventController {

    /**
     * fields.
     */

    @Autowired
    private EventBizService eventBizService;

    /**
     * public methods.
     */

    @RequestMapping(value = "/{openingCode}", method = RequestMethod.GET)
    public EventModel getEvent(@PathVariable String openingCode) {
        return eventBizService.findByOpeningCode(openingCode);
    }

}
