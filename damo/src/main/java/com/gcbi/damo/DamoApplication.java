package com.gcbi.damo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gcbi.damo"})
public class DamoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DamoApplication.class, args);
    }
}
