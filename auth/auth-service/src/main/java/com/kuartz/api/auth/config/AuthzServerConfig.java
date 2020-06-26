package com.kuartz.api.auth.config;

import com.kuartz.api.auth.config.property.AuthzProperties;
import com.kuartz.api.auth.handler.KuartzAccessDeniedHandler;
import com.kuartz.api.auth.handler.KuartzAuthenticationEntryPoint;
import com.kuartz.api.auth.handler.KuartzResponseExceptionTranslator;
import com.kuartz.api.auth.provider.KuartzClientDetailsProvider;
import com.kuartz.api.auth.provider.KuartzJwtAccessTokenConverter;
import com.kuartz.core.env.factory.YamlPropertyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@ComponentScan(basePackages = "com.kuartz.core") // TODO: @kutay-celebi 07.03.2020 get constants from core
@EnableConfigurationProperties({AuthzProperties.class})
@PropertySource(factory = YamlPropertyFactory.class, value = "classpath:api-path.yml")
public class AuthzServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthzProperties authzProperties;

    @Autowired
    private AuthenticationManager authManager;

    //@Autowired
    //private TokenStore tokenStore;

    //@Autowired
    //private JwtAccessTokenConverter accessTokenConverter;

    @Autowired
    private KuartzClientDetailsProvider kuartzClientDetailsProvider;

    private DefaultTokenServices defaultTokenServices;

    @Autowired
    private KuartzResponseExceptionTranslator translator;

    @Autowired
    private KuartzAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private KuartzAuthenticationEntryPoint entryPoint;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authManager)
                 .tokenStore(tokenStore())
                 .tokenServices(tokenService())
                 .accessTokenConverter(jwtTokenEnhancer())
                 .exceptionTranslator(translator)
                 .setClientDetailsService(kuartzClientDetailsProvider);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(passwordEncoder());
        security.tokenKeyAccess("permitAll()");
        security.checkTokenAccess("permitAll()");
        security.accessDeniedHandler(accessDeniedHandler);
        security.authenticationEntryPoint(entryPoint);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(kuartzClientDetailsProvider);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected TokenStore tokenStore() {
        return new JwtTokenStore(jwtTokenEnhancer());
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenService() {
        if (defaultTokenServices == null) {
            defaultTokenServices = new DefaultTokenServices();
            defaultTokenServices.setSupportRefreshToken(true);
            defaultTokenServices.setReuseRefreshToken(false);
            defaultTokenServices.setTokenStore(tokenStore());
            defaultTokenServices.setClientDetailsService(kuartzClientDetailsProvider);
            //TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
            //enhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer(), tokenEnhancer));
            defaultTokenServices.setTokenEnhancer(jwtTokenEnhancer());
            return defaultTokenServices;
        }
        return defaultTokenServices;
    }


    @Bean
    protected KuartzJwtAccessTokenConverter jwtTokenEnhancer() {
        KuartzJwtAccessTokenConverter jwtAccessTokenConverter = new KuartzJwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("test");
        jwtAccessTokenConverter.setVerifierKey("test");
        return jwtAccessTokenConverter;
    }

}
