package com.xiaoai.match.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/25 16:49
 */

/**
 * 用户退出队伍请求体
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 4421147153115664548L;

    /**
     * 队伍id
     */
    private Long teamId;
}
