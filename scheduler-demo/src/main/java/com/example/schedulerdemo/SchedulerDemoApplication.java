package com.example.schedulerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * https://www.callicoder.com/spring-boot-task-scheduling-with-scheduled-annotation/
 */
@SpringBootApplication
@EnableScheduling
public class SchedulerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerDemoApplication.class, args);
    }
}
