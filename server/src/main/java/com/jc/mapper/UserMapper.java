package com.jc.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.entity.vo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<com.jc.entity.pojo.User> {
    com.jc.entity.pojo.User selectByName(String name);

    Integer selectId(String name);

    User selectByview(Integer userId);
}
