package com.xiaoai.match.service;

import com.xiaoai.match.mapper.UserMapper;
import com.xiaoai.match.model.domain.User;
import com.xiaoai.match.once.InsertUsers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/19 10:49
 */
@SpringBootTest
public class InsertUsersTest {
    @Resource
    private UserService userService;

    //CPU 密集型: 分配的核心线程数 = CPU数 + 1
    //IO  密集型: 分配的核心线程数 = 2 * CPU数
    private ExecutorService executorService = new ThreadPoolExecutor(60, 50000, 10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));

    /**
     * 批量插入用户
     */
    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000;
        List<User> userList = new ArrayList<>();
        for(int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假小艾");
            user.setUserAccount("fakexiaoai");
            user.setAvatarUrl("1bdf500d-bccc-40e0-8c39-c1c469889683.png");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("1234");
            user.setEmail("123@qq.com");
            user.setTags("[]");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("1");
        }
        userService.saveBatch(userList, 10000);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    /**
     * 并发批量插入用户
     */
    @Test
    public void doConcurrentInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //分十组
        int batchSize = 5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<User> userList = new ArrayList<>();
            while(true) {
                j++;
                User user = new User();
                user.setUsername("假小艾");
                user.setUserAccount("fakexiaoai");
                user.setAvatarUrl("1bdf500d-bccc-40e0-8c39-c1c469889683.png");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setPhone("1234");
                user.setEmail("123@qq.com");
                user.setTags("[]");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setPlanetCode("1");
                userList.add(user);
                if(j % batchSize == 0) {
                    break;
                }
            }
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("threadName" + Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            }, executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        //20秒10万条
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
