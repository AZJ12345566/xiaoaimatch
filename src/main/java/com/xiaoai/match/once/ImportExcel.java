package com.xiaoai.match.once;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/12 09:11
 */

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;

import java.util.List;

/**
 * 导入excel
 */
public class ImportExcel {
    /**
     * 读取数据
     */
    public static void main(String[] args) {
        String fileName = "/Users/azj/Downloads/xiaoai-backend/src/main/resources/testExcel.xlsx";
        //readByListener(fileName);
        synchronousRead(fileName);
    }

    /**
     * 监听器
     * @param fileName
     */
    public static void readByListener(String fileName) {
        EasyExcel.read(fileName, MatchUserTableInfo.class, new TableListener()).sheet().doRead();
    }

    /**
     * 同步读
     * @param fileName
     */
    public static void synchronousRead(String fileName) {
        //这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<MatchUserTableInfo> totalDataList =
                EasyExcel.read(fileName).head(MatchUserTableInfo.class).sheet().doReadSync();
        for (MatchUserTableInfo matchUserTableInfo : totalDataList) {
            System.out.println(matchUserTableInfo);
        }
    }
}
