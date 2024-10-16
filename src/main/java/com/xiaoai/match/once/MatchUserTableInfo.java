package com.xiaoai.match.once;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/12 09:14
 */

/**
 * 表格用户信息
 */
@Data
public class MatchUserTableInfo {

    @ExcelProperty("姓名")
    private String name;

    /**
     * id
     */
    @ExcelProperty("用户id")
    private String id;

    /**
     * 用户昵称
     */
    @ExcelProperty("用户名称")
    private String username;
}
