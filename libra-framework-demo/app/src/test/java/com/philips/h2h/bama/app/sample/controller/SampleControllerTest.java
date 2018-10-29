/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.sample.controller;

import com.philips.h2h.bama.app.sample.mvc.controller.SampleController;
import com.philips.h2h.bama.platform.core.test.BaseServiceIntegrationTest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Sample test class
 */
public class SampleControllerTest
        extends BaseServiceIntegrationTest {

    @Autowired
    private SampleController controller;

    @Test
    public void testGetShow() {
        // GIVEN
        String name = "bama";
        // WHEN
        SampleController.SampleModel model = controller.getShow(name);
        // THEN
        assertNotNull(model);
        assertTrue(StringUtils.containsIgnoreCase(model.getContent(), "hello"));
        assertTrue(StringUtils.containsIgnoreCase(model.getContent(), name));
    }
}