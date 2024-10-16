package com.xiaoai.match.once;
import java.util.Date;

import com.xiaoai.match.mapper.UserMapper;
import com.xiaoai.match.model.domain.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/19 10:17
 */
@Component
public class InsertUsers {
    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     */
    //@Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000;
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
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        new InsertUsers().doInsertUsers();
    }
}
