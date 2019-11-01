package com.example.demo;

import com.example.demo.map.MapTest;
import com.example.demo.map.Region;
import com.example.demo.redis.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author daizhichao
 * @date 2018/5/7
 */
@RestController
@RequestMapping("/helloWorld")
public class HelloWordController {

    @Autowired
    private MapTest mapTest;

    @Autowired
    private RedisTestService redisTestService;

//    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping("/test")
    public String test() {
//        List<Region> region = mapTest.getRegion();
//        System.out.println(region);
        return "helloWord test";
    }
    @RequestMapping("/redis")
    public String findRedis() {
        return redisTestService.findRedis();
    }

    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a, b));
    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }
}
