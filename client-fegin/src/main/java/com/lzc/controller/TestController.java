package com.lzc.controller;

import com.lzc.entity.Admin;
import com.lzc.fegin.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestFeign testFeign;

    @RequestMapping("getTest")
    public String getTest(){
        Admin admin = new Admin();
        return testFeign.getTestFeign("忍不住拍了拍自己的肉");
    }

    /**
     *
     * @return
     */
    @RequestMapping("getTestAdmin")
    public Admin getTestAdmin(){
        Admin admin = new Admin();
        admin.setUsername("小狼崽子-------->格林,hello word ");
        admin.setPassword("19940628");
        return testFeign.getTestAdmin(admin);
    }

}