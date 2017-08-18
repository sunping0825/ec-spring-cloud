package com.ecspringcloud.easycloud.consumer.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author sunping
 * @create 2017/8/17
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.ecspringcloud.easycloud")
@EnableDiscoveryClient
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
