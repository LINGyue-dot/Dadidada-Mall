package com.jc.service.impl;


import com.jc.entity.pojo.User;
import com.jc.mapper.UserMapper;
import com.jc.mapper.UserPasswordMapper;
import com.jc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPasswordMapper userPasswordMapper;


    @Override
    public User getInformation(Map<String, String> map) {
        String name = map.get("userName");
        String requestPwd = map.get("password");
        Integer userId = userMapper.selectId(name);
        String userPwd = userPasswordMapper.selectPwd(userId);
        if(requestPwd.equals(userPwd))
        {
            return userMapper.selectByName(name);
        }

        else{
            return null;
        }
    }

    @Override
    public Integer add(User user) {
        User isExist = userMapper.selectByName(user.getUserName());
        if(isExist==null){
            userMapper.insert(user);
            return user.getUserId();
        }
        else{
            return -1;
        }

    }


    @Override
    public Integer update(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public Integer selectId(String name) {

        return userMapper.selectId(name);
    }

    @Override
    public User findname(String name) {
        return userMapper.selectByName(name);
    }
}
