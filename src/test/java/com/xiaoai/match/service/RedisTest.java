package com.xiaoai.match.service;

import com.xiaoai.match.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/21 09:48
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("xiaoai1", "chaojixiaoai");
        valueOperations.set("xiaoai2", 1);
        valueOperations.set("xiaoai3", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("xiaoai");
        valueOperations.set("xiaoai4", user);
        //查
        Object xiaoai = valueOperations.get("xiaoai1");
        valueOperations.get("xiaoai2");
        valueOperations.get("xiaoai3");
        valueOperations.get("xiaoai4");
    }
}
