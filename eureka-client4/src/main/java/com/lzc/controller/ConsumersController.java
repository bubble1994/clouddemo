package com.lzc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * @HystrixCommand(fallbackMethod = "") 短路设置 如果当前方法请求失败会请求fallbackMethod = ""中的方法
     * fallbackMethod 值为替代当前断路方法的替代方法
     * @return
     */
    @RequestMapping("getTest")
    @HystrixCommand(fallbackMethod = "getTestFallbackMethod")
    public String getTest(){
        /**
         * ResponseEntity 响应体 封装的有响应的状态码 和 响应信息 以及响应体
         */
        String object = restTemplate.getForObject("http://client-1/test?name=zhangsan", String.class);
        return object;
    }

    public String getTestFallbackMethod(){
        return " -*_*- !！    哎呀妈呀,请求失败，请稍后再试!     -*_*- !！";
    }
}