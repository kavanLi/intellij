/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.schedulerdemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * class description goes here.
 */
@Component
public class ScheduledTasks {

    /* fields -------------------------------------------------------------- */

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */

    //@Scheduled(fixedRate = 2000)
    //public void scheduleTaskWithFixedRate() {
    //    logger.info("Fixed Rate Task :: Execution Time - {}",
    //            dateTimeFormatter.format(LocalDateTime.now()));
    //
    //    logger.info("Current Thread : {}", Thread.currentThread().getName());
    //
    //}

    //@Scheduled(fixedDelay = 2000)
    //public void scheduleTaskWithFixedDelay() {
    //    logger.info("Fixed Delay Task :: Execution Time - {}",
    //            dateTimeFormatter.format(LocalDateTime.now()));
    //    try {
    //        TimeUnit.SECONDS.sleep(5);
    //    } catch (InterruptedException ex) {
    //        logger.error("Ran into an error {}", ex);
    //        throw new IllegalStateException(ex);
    //    }
    //
    //    logger.info("Current Thread : {}", Thread.currentThread().getName());
    //}

    //@Scheduled(fixedRate = 2000, initialDelay = 5000)
    //public void scheduleTaskWithInitialDelay() {
    //    logger.info("Fixed Rate Task with Initial Delay :: Execution Time - {}",
    //            dateTimeFormatter.format(LocalDateTime.now()));
    //
    //    logger.info("Current Thread : {}", Thread.currentThread().getName());
    //
    //}

    @Scheduled(cron = "0 * * * * ?")
    public void scheduleTaskWithCronExpression() {
        logger.info("Cron Task :: Execution Time - {}",
                dateTimeFormatter.format(LocalDateTime.now()));

        logger.info("Current Thread : {}", Thread.currentThread().getName());
    }

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}