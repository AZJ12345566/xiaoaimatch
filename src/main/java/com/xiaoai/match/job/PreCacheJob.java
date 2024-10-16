package com.xiaoai.match.job;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/22 08:44
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoai.match.mapper.UserMapper;
import com.xiaoai.match.model.domain.User;
import com.xiaoai.match.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存预热任务
 */
@Component
@Slf4j
public class PreCacheJob {
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;

    //重点用户
    private List<Long> mainUserList = Arrays.asList(1L);

    //每天执行，预热推荐用户
    @Scheduled(cron = "0 0 0 * * *")
    public void doCacheRecommendUser() {
        RLock lock = redissonClient.getLock("xiaoai:precachejob:docache:lock");
        try {
            //只有一个程序能获取锁
            if (lock.tryLock(0, 30000L, TimeUnit.MILLISECONDS)) {
                for (Long userId : mainUserList) {
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
                    String redisKey = String.format("xiaoai:user:recommend:%s", userId);
                    ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                    //写缓存
                    try {
                        valueOperations.set(redisKey, userPage, 30000, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        log.error("redis set key error", e);
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //只能释放自己的锁
            if(lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
