package com.gcbi.damo.config;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.gcbi.gcuser.api.AuthApi;
import com.gcbi.gcuser.api.MemberApi;


@Configuration
public class HessianConfig {

    @Resource
    HessianProperties properties;

    @Bean(name = "authApi")
    public HessianProxyFactoryBean authApi() {
        HessianProxyFactoryBean factory = createHessianProxyFactoryBean(properties.getAuthApi());
        factory.setServiceInterface(AuthApi.class);
        return factory;
    }

    @Bean(name = "memberApi")
    public HessianProxyFactoryBean memberApi() {
        HessianProxyFactoryBean factory = createHessianProxyFactoryBean(properties.getMemberApi());
        factory.setServiceInterface(MemberApi.class);
        return factory;
    }

    private HessianProxyFactoryBean createHessianProxyFactoryBean(String serviceUrl) {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
        factory.setServiceUrl(serviceUrl);
        factory.setConnectTimeout(50000);
        factory.setReadTimeout(15000);
        return factory;
    }

}
