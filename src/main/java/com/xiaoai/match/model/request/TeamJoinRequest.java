package com.xiaoai.match.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/25 16:49
 */
@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = 4421147153115664548L;

    /**
     * 队伍id
     */
    private Long teamId;

    /**2
     * 密码
     */
    private String password;

}
