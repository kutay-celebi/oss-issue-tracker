package com.kuartz.api.issuetracker.service.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuartz.core.data.jpa.bean.KuartzRepositoryFactoryBean;
import com.kuartz.core.env.KuartzMessageSource;
import com.kuartz.core.env.factory.YamlPropertyFactory;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

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
@EnableZuulProxy
@EnableEurekaClient
@PropertySources({
        @PropertySource(factory = YamlPropertyFactory.class, value = "classpath:issue-tracker-api-path.yml")
})
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

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oauth2ClientContext,
                                                            OAuth2ProtectedResourceDetails resource) {
        return new OAuth2FeignRequestInterceptor(oauth2ClientContext, resource);
    }

    @Bean
    protected OAuth2ProtectedResourceDetails resource() {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        resource.setAccessTokenUri("http://127.0.0.1:9999/oauth/token");
        resource.setUserAuthorizationUri("http://127.0.0.1:9000/oauth/authorize");
        resource.setClientId("issue-tracker");
        resource.setClientSecret("test");
        return resource;
    }
}
