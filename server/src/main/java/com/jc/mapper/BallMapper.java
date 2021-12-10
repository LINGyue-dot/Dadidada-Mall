package com.jc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.entity.pojo.Ballrule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface BallMapper extends BaseMapper<Ballrule> {

    List<Ballrule> selectAll();
}
