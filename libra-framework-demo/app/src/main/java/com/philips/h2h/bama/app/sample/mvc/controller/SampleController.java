/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.sample.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.platform.core.domain.model.common.BaseModel;

/**
 * REST controller for Demo.
 */
@RestController
@RequestMapping("/sample")
public class SampleController {

    /* fields ------------------------------------------------------ */

    private final static Logger logger = LoggerFactory.getLogger(SampleController.class);

    /* public methods ------------------------------------------------------ */

    @RequestMapping("/{name}")
    public SampleModel getShow(@PathVariable String name) {

        SampleModel model = new SampleModel();
        model.setContent("Hello, " + name);

        logger.info(model.toString());
        return model;
    }

    public class SampleModel extends BaseModel {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "SampleModel{" + "content='" + content + '\'' + '}';
        }
    }
}
