package com.ecspringcloud.easycloud.consumer.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Administrator on 2017/8/8.
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.ecspringcloud.easycloud")
@EnableDiscoveryClient
public class ConsumerUserApplication
{
    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserApplication.class, args);
    }
}
