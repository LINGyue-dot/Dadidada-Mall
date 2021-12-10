package com.jc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.entity.pojo.Dadcomment;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DadCommentMapper extends BaseMapper<Dadcomment> {

    List<Dadcomment> selectByPostId(Integer postId);
}
