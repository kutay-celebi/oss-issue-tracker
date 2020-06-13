//package com.kuartz.gateway.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
//@Configuration
//@EnableResourceServer
//@ComponentScan(basePackages = "com.kuartz.core.auth")
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    @Autowired
//    private TokenStore tokenStore;
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/auth/**").permitAll()
//            .anyRequest().authenticated()
//            .and().formLogin().loginPage("/login").permitAll()
//            .and().cors().disable().csrf().disable();
//        //todo redis'e alinacak.
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) //todo digerlerine bakalim
//            .and().authorizeRequests()
//            .anyRequest().authenticated();
//
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        super.configure(resources);
//        resources.tokenStore(tokenStore).resourceId("gateway");
//    }
//
//
//}
