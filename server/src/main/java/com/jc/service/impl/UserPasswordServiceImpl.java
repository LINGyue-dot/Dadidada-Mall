package com.jc.service.impl;

import com.jc.entity.pojo.Userpassword;
import com.jc.mapper.UserMapper;
import com.jc.mapper.UserPasswordMapper;
import com.jc.service.UserPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordServiceImpl implements UserPasswordService {

    @Autowired
    private UserPasswordMapper userPasswordMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String find(String userName) {
        Integer id = userMapper.selectId(userName);
        if(userPasswordMapper.selectById(id) != null) return "true";
        else return "false";
    }

    @Override
    public void add(Userpassword userpassword) {
        userPasswordMapper.insert(userpassword);
    }

}
