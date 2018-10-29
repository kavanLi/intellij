package com.gcbi.damo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "remote.hessian.url")
@PropertySource("file:/gcbi/config/commons/hessian.properties")
public class HessianProperties {

    String authApi;

    String memberApi;
}
