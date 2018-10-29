/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.schedulerdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * class description goes here.
 */
//@Configuration
//public class SchedulerConfig implements SchedulingConfigurer {
//    private final int POOL_SIZE = 10;
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
//
//        threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
//        threadPoolTaskScheduler.setThreadNamePrefix("my-scheduled-task-pool-");
//        threadPoolTaskScheduler.initialize();
//
//        scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
//    }
//}