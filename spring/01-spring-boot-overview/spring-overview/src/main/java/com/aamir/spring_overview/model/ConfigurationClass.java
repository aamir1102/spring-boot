package com.aamir.spring_overview.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

    @Bean
    public BlueLock blueLock(){
        return new BlueLock();
    }
}
