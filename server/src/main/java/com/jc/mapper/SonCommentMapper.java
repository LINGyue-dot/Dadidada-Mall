package com.jc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.entity.pojo.Soncomment;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SonCommentMapper extends BaseMapper<Soncomment> {

    List<Soncomment> selectByDadCommentId(Integer DadcommentId);
}
