package com.lzc;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient 可以被Eureka发现 可以被 zookeeper发现  声明当前项目是一个客户端
 *
 * @EnableEurekaClient 可以被Eureka发现 声明当前项目是一个客户端
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
public class EurekaFeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeginApplication.class, args);
    }

    /**
     * 创建一个RestTemplate
     * RestTemplate 可以做Restful 的请求
     * @return
     * @LoadBalanced 开启负载均衡
     * 原理：
     * RestTemplate--> 提供发送功能
     * LoadBalanced--> 负载功能（类似于拦截器）
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Configuration
    public class feignConf {
        @Bean
        public Logger.Level feignConfiguration() {
            return Logger.Level.FULL;
        }
    }

}
