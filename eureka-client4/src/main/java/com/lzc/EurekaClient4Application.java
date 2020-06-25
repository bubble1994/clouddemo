package com.lzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @EnableDiscoveryClient 可以被Eureka发现 可以被 zookeeper发现  声明当前项目是一个客户端
 *
 * @EnableEurekaClient 可以被Eureka发现 声明当前项目是一个客户端
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class EurekaClient4Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient4Application.class, args);
    }

}
