/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************//*
 * *************************************************************************
 *                         BAMA FRAMEWORK
 *           © BAMA framework, (2016). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 * *************************************************************************
 */

package com.philips.h2h.bama.platform.core.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Base integration test with memory DB environment and rollback disabled.
 */
@ContextConfiguration(locations = {"classpath:memory-db-application-context.xml"})
@TransactionConfiguration(defaultRollback = false)
public abstract class InMemoryDbIntegrationTest extends TransactionalIntegrationTest {
    public InMemoryDbIntegrationTest() {
    }
}
