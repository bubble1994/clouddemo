package com.lzc.controller;

import com.lzc.EurekaClient2Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: liuzhichao
 * @Date: 2020/6/26 00:25
 * @Description:
 */
@RestController
public class ConsumersController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("getTest")
    public String getTest(){
        /**
         * ResponseEntity 响应体 封装的有响应的状态码 和 响应信息 以及响应体
         */
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8061/test?name=zhangsan", String.class);
        String object = restTemplate.getForObject("http://localhost:8061/test?name=zhangsan", String.class);
        System.out.println(object);
        String body = entity.getBody();
        System.out.println("body"+body);
        HttpStatus statusCode = entity.getStatusCode();
        System.out.println("statusCode"+statusCode);
        return body;
    }
}