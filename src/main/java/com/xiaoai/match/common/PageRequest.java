package com.xiaoai.match.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/25 08:35
 */

/**
 * 通用分页请求参数
 */
@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 8144226788904159891L;

    /**
     * 页面大小
     */
    protected int pageSize = 10;

    /**
     * 当前是第几页
     */
    protected int pageNum = 1;
}
