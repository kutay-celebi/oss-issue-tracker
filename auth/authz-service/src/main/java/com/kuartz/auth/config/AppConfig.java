package com.kuartz.auth.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuartz.core.data.jpa.bean.KuartzRepositoryFactoryBean;
import com.kuartz.core.env.KuartzMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.annotation.PostConstruct;

@Configuration
@EnableAuthorizationServer
@EnableJpaRepositories(basePackages = "com.kuartz.auth.repository", repositoryFactoryBeanClass = KuartzRepositoryFactoryBean.class)
@EntityScan(basePackages = "com.kuartz.auth.entity")
public class AppConfig {
    @Autowired
    private KuartzMessageSource messageSource;

    @PostConstruct
    public void kuartzMessageSource() {
        messageSource.addBasenames("authz_message");
    }

    @Bean
    public ObjectMapper firstObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper;
    }
}
