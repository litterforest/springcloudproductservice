package com.softd.test.spring.cloud.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProductServiceApplication.class, args);
    }
}
