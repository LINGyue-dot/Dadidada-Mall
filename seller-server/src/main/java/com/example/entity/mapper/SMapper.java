package com.example.entity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.pojo.S;

import java.util.List;

public interface SMapper extends BaseMapper<S> {
    List<S> fins();
}
