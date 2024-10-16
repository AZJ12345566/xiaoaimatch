package com.xiaoai.match.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoai.match.model.domain.UserTeam;
import com.xiaoai.match.mapper.UserTeamMapper;
import com.xiaoai.match.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author azj
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2024-09-25 07:31:25
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




