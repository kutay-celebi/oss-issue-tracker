package com.kuartz.api.issuetracker.service.config;

import com.kuartz.core.auth.handler.KuartzAccessDeniedHandler;
import com.kuartz.core.auth.handler.KuartzAuthenticationEntryPoint;
import com.kuartz.core.auth.handler.KuartzAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@EnableOAuth2Client
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private KuartzAuthenticationEntryPoint entryPoint;

    @Autowired
    private KuartzAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private KuartzAuthenticationFailureHandler failureHandler;

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//            .authorizeRequests()
//            .antMatchers("/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**").permitAll()
//            .and()
//            .authorizeRequests().anyRequest().authenticated()
//            .and()
//            .exceptionHandling()
//            .authenticationEntryPoint(entryPoint)
//            .accessDeniedHandler(accessDeniedHandler)
//        .and().cors().disable().csrf().disable();
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.accessDeniedHandler(accessDeniedHandler);
//        resources.authenticationEntryPoint(entryPoint);
//        // TODO: @kutay-celebi 07.03.2020 edit to get from yml
//        resources.resourceId("issue_tracker");
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and().cors().disable().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        resources.resourceId("issue_tracker");
    }

}
