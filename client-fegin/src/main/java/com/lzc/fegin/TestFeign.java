package com.lzc.fegin;

import com.lzc.entity.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @FeignClient() 声明为Feign客户端  Http客户端  支持SpringMVC的注解
 *
 * value 要请求的服务的名字
 */
@FeignClient(value = "client-1",fallback = TestFeignHystrix.class)
public interface TestFeign {
    /**
     * 声明要请求服务的哪个接口
     *
     * 当前方法的返回值类型和形参必须和被请求的接口一致  方法名不要求
     * @param name
     * @return
     */
    @RequestMapping("test")
    String getTestFeign(@RequestParam("name") String name);

//    @RequestMapping(path = "testAdmin", method = RequestMethod.POST)
//    Admin getTestAdmin(Admin admin);

    @PostMapping("testAdmin")
    Admin getTestAdmin(@RequestBody Admin admin);
}