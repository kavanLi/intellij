/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.code.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.philips.h2h.bama.platform.code.SerialNumberGenerator;
import com.philips.h2h.bama.platform.code.UniqueCodeGenerator;

/**
 * An empty default implementation of SerialNumberGenerator. Handy for subclass
 * to overwrite one of the methods.
 */
public class DefaultSerialNumberGenerator implements SerialNumberGenerator {

    /* fields ------------------------------------------------------ */

    @Autowired
    protected UniqueCodeGenerator uniqueCodeGenerator;

    /* public methods ------------------------------------------------------ */

    /**
     * @see SerialNumberGenerator#generate()
     */
    @Override
    public String generate() {
        return uniqueCodeGenerator.generateCodeNumeric();
    }

    /**
     * @see SerialNumberGenerator#generateById(Long)
     */
    @Override
    public String generateById(Long id) {
        return String.valueOf(id);
    }

    /**
     * @see SerialNumberGenerator#generateByIds(Long, Long)
     */
    @Override
    public String generateByIds(Long id1, Long id2) {
        return String.valueOf(id1) + String.valueOf(id2);
    }
}
