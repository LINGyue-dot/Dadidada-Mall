package com.jc.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.entity.pojo.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper extends BaseMapper<Post> {

    List<Post> selectByPage(Boolean isDelete,Integer state);
}
