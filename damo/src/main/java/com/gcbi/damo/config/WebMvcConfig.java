package com.gcbi.damo.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import com.gcbi.cloud.common.core.web.interceptor.LogInterceptor;

import com.gcbi.damo.cotroller.interceptor.AuthInterceptor;

@Configuration
@Component
/**
 * WebMvcConfigurerAdapter已过时,现在推荐WebMvcConfigurationSupport
 *
 */
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Resource
    LogInterceptor logInterceptor;

    @Resource
    AuthInterceptor authInterceptor;

    @Bean
    public WebExceptionHandler webExceptionHandler() {
        WebExceptionHandler handler = new WebExceptionHandler();
        handler.setErrPage("/error.html");
        return handler;
    }

    @Bean
    public LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/ajax/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/ajax/**").excludePathPatterns("/ajax/login");
        super.addInterceptors(registry);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/css/**").addResourceLocations("classpath:/META-INF/resources/css/");
        resourceHandlerRegistry.addResourceHandler("/images/**").addResourceLocations("classpath:/META-INF/resources/images/");
        resourceHandlerRegistry.addResourceHandler("/js/**").addResourceLocations("classPath:/META-INF/resources/js/");
        super.addResourceHandlers(resourceHandlerRegistry);
    }
}
