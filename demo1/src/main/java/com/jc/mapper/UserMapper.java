package com.jc.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.entity.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    User selectByName(String name);
    List<User> selectAll();
    Integer selectId(String name);
}
