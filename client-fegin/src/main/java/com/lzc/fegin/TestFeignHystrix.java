package com.lzc.fegin;

import com.lzc.entity.Admin;
import org.springframework.stereotype.Service;

/**
 * @Auther: liuzhichao
 * @Date: 2020/6/26 20:51
 * @Description:
 */
@Service
public class TestFeignHystrix implements TestFeign {
    @Override
    public String getTestFeign(String name) {
        return "请求失败"+name;
    }

    @Override
    public Admin getTestAdmin(Admin admin) {
        return new Admin();
    }
}