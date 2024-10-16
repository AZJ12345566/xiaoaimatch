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
public class TeamUpdateRequest implements Serializable {

    private static final long serialVersionUID = 4421147153115664548L;

    /**
     * 队伍id
     */
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;

    /**
     * 密码
     */
    private String password;

}
