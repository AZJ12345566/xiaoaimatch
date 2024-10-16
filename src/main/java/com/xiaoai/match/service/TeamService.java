package com.xiaoai.match.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoai.match.model.domain.Team;
import com.xiaoai.match.model.domain.User;
import com.xiaoai.match.model.dto.TeamQuery;
import com.xiaoai.match.model.request.TeamJoinRequest;
import com.xiaoai.match.model.request.TeamQuitRequest;
import com.xiaoai.match.model.request.TeamUpdateRequest;
import com.xiaoai.match.model.vo.TeamUserVO;

import java.util.List;

/**
* @author azj
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-09-23 10:57:36
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     * @param team
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 解散队伍
     * @param id
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long id, User loginUser);
}
