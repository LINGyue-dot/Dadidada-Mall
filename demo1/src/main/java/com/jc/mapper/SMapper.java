package com.jc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.entity.pojo.S;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SMapper extends BaseMapper<S> {

    List<S> list();
    List<S> list1(@Param("sno") String sno);
}
