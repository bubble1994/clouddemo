package com.lzc.controller;

import com.lzc.entity.Admin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 对象的接收
     * 1. post 请求
     * 2. @RequestBody (必须加)
     * @param admin
     * @return
     */
    @PostMapping("testAdmin")
    public Admin test(@RequestBody Admin admin){
        System.out.println("有人调用我，这是他传过来的。body:"+admin);
        return admin;
    }

}