/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Transaction is set per test case.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class TransactionalIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {
    public TransactionalIntegrationTest() {
    }
}
