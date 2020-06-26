package com.kuartz.api.issuetracker.serrvice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Kutay Çelebi
 * @since 26.06.2020
 */
@EnableEurekaClient
@SpringBootApplication
public class IssueTrackerApiApp {
    public static void main(String[] args) {
        SpringApplication.run(IssueTrackerApiApp.class, args);
    }
}
