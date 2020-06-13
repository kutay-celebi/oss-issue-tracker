package com.kuartz.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Kutay Celebi
 * @since 12.10.2019
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class KuartzGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(KuartzGatewayApplication.class, args);
    }
}