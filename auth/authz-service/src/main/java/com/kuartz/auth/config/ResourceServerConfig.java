package com.kuartz.auth.config;

import com.kuartz.auth.handler.KuartzAccessDeniedHandler;
import com.kuartz.auth.handler.KuartzAuthenticationEntryPoint;
import com.kuartz.auth.handler.KuartzAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private KuartzAuthenticationEntryPoint entryPoint;

    @Autowired
    private KuartzAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private KuartzAuthenticationFailureHandler failureHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**").permitAll()
            .antMatchers(HttpMethod.OPTIONS, "/oauth/*").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/user/changePassword").permitAll()
            .and()
            .authorizeRequests().anyRequest().authenticated()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(entryPoint)
            .accessDeniedHandler(accessDeniedHandler)
            // TODO: @kutay-celebi 07.03.2020 will be able
            //.and().cors().configurationSource(corsFilter()).and().csrf().disable();
        .and().cors().disable().csrf().disable();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.accessDeniedHandler(accessDeniedHandler);
        resources.authenticationEntryPoint(entryPoint);
        // TODO: @kutay-celebi 07.03.2020 edit to get from yml
        resources.resourceId("uaa");
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        ArrayList<String> responseHeaderAllow = new ArrayList<>();
        config.setMaxAge(18000L);
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
