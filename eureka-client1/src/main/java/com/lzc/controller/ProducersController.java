package com.lzc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: liuzhichao
 * @Date: 2020/6/26 00:25
 * @Description:
 */
@RestController
public class ProducersController {

    /**
     * @Value("${server.port}") 获取application配置文件中的值
     */
    @Value("${server.port}")
    private String port;

    @RequestMapping("test")
    public String test(String name){
        return "我是生产者，端口号："+port+"，内容是："+name;
    }

    @RequestMapping("testMap")
    public String testMap(String name, String password){
        return "我是生产者，端口号："+port+"，用户名："+name+"， 密码："+password;
    }
}