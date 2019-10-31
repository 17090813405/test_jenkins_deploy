package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @author daizhichao
 * @date 2019/4/17
 */
@Service
public class RedisTestService {

    @Autowired
    private JedisCluster jedisCluster;

    public String findRedis() {
        jedisCluster.set("xingm", "hello wenqy");
        return jedisCluster.get("xingm");
    }
}
