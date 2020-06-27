package com.kuartz.api.issuetracker.service.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuartz.core.data.jpa.bean.KuartzRepositoryFactoryBean;
import com.kuartz.core.env.KuartzMessageSource;
import com.kuartz.core.env.factory.YamlPropertyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

/**
 * @author Kutay Çelebi
 * @since 27.06.2020
 */
@Configuration
@ComponentScan(basePackages = "com.kuartz.core")
@EnableJpaRepositories(basePackages = "com.kuartz.api.issuetracker.service.repository",
        repositoryFactoryBeanClass = KuartzRepositoryFactoryBean.class)
@EntityScan(basePackages = "com.kuartz.api.issuetracker.service.entity")
@PropertySource(factory = YamlPropertyFactory.class, value = "classpath:api-path.yml")
@EnableZuulProxy
@EnableFeignClients
@EnableEurekaClient
public class IssueTrackerServiceConfig {

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
