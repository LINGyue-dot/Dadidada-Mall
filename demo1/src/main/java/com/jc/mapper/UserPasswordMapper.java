package com.jc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.entity.pojo.Userpassword;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPasswordMapper extends BaseMapper<Userpassword> {
    String selectPwd(Integer userId);
    Userpassword researchById(Integer userId);
}
