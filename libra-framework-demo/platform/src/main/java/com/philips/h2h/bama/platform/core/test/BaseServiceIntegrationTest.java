/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Base integration test with real DB environment and rollback disabled.
 * Transaction is up to container configuration.
 */
@ContextConfiguration(locations = {"classpath:standalone-db-application-context.xml"})
@TransactionConfiguration(defaultRollback = false)
public abstract class BaseServiceIntegrationTest extends BaseIntegrationTest {
    public BaseServiceIntegrationTest() {
    }
}
