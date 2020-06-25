package com.lzc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
        String object = restTemplate.getForObject("http://client-1/test?name=libai", String.class);
        return object;
    }

    @RequestMapping("/getTestMap")
    @HystrixCommand(fallbackMethod = "getTestFallbackMethod")
    public String getTestMap(){
        Map map = new HashMap();
        map.put("name","熬夜选手");
        map.put("password","123456");
        /**
         * ResponseEntity 响应体 封装的有响应的状态码 和 响应信息 以及响应体
         */
        String object = restTemplate.getForObject("http://client-1/testMap?name={name}&&password={password}", String.class,map);
        return object;
    }



    public String getTestFallbackMethod(){
        return " -*_*- !！    哎呀妈呀,请求失败，请稍后再试!     -*_*- !！";
    }
}