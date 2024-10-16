package com.xiaoai.match.once;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/13 07:49
 */

import com.alibaba.excel.EasyExcel;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 导入用户到数据库
 */
public class ImportMatchUser {
    public static void main(String[] args) {
        //String fileName = "/Users/azj/Downloads/xiaoai-backend/src/main/resources/testExcel.xlsx";
        String fileName = "/Users/azj/Downloads/xiaoai-backend/src/main/resources/prodExcel.xlsx";
        List<MatchUserTableInfo> userInfoList =
                EasyExcel.read(fileName).head(MatchUserTableInfo.class).sheet().doReadSync();
        System.out.println("总数 = " + userInfoList.size());
        Map<String, List<MatchUserTableInfo>>listMap =
                userInfoList.parallelStream()
                        .filter(userInfo -> StringUtils.isNotEmpty(userInfo.getUsername()))
                        .collect(Collectors.groupingBy(MatchUserTableInfo::getUsername));
        for(Map.Entry<String, List<MatchUserTableInfo>> stringListEntry : listMap.entrySet()) {
            if(stringListEntry.getValue().size() > 1) {
                System.out.println("username = " + stringListEntry.getKey());
                System.out.println();
            }
        }
        System.out.println("不重复昵称数 = " + listMap.keySet().size());
    }
}
