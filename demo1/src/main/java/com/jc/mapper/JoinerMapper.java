package com.jc.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.entity.pojo.Joiner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinerMapper extends BaseMapper<Joiner> {
    List<Joiner> list();
    List<Joiner> listId(Integer joinerId);
}
