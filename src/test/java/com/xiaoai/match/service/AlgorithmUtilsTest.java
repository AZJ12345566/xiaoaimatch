package com.xiaoai.match.service;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/10/10 09:14
 */

import com.xiaoai.match.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 算法工具类测试
 */
public class AlgorithmUtilsTest {

    @Test
    void test() {
        String str1 = "小艾是狗";
        String str2 = "小艾不是狗";
        String str3 = "小艾是狗不是狗";
        //1
        int score1 = AlgorithmUtils.minDistance(str1, str2);
        //3
        int score2 = AlgorithmUtils.minDistance(str1, str3);
        System.out.println(score1);
        System.out.println(score2);
    }

    @Test
    void testCompareTags() {
        List<String> tagList1 = Arrays.asList("Java", "大一", "男");
        List<String> tagList2 = Arrays.asList("Java", "大一", "女");
        List<String> tagList3 = Arrays.asList("python", "大二", "女");
        //1
        int score1 = AlgorithmUtils.minDistance(tagList1, tagList2);
        //3
        int score2 = AlgorithmUtils.minDistance(tagList1, tagList3);
        System.out.println(score1);
        System.out.println(score2);
    }
}
