package com.xiaoai.match.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoai.match.model.domain.Tag;
import com.xiaoai.match.service.TagService;
import com.xiaoai.match.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author azj
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2024-09-07 08:55:21
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




