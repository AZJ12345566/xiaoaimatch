package com.xiaoai.match.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/25 08:35
 */

/**
 * 通用删除请求参数
 */
@Data
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = 8144226788904159891L;

    private long id;
}
