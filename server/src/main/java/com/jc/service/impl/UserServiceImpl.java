package com.jc.service.impl;


import com.jc.entity.vo.User;
import com.jc.mapper.UserMapper;
import com.jc.mapper.UserPasswordMapper;
import com.jc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPasswordMapper userPasswordMapper;


    @Override
    public com.jc.entity.pojo.User getInformation(Map<String, String> map) {
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
    public Integer add(com.jc.entity.pojo.User user) {
        com.jc.entity.pojo.User isExist = userMapper.selectByName(user.getUserName());
        if(isExist==null){
            userMapper.insert(user);
            return user.getUserId();
        }
        else{
            return -1;
        }

    }


    @Override
    public Integer update(com.jc.entity.pojo.User user) {
        return userMapper.updateById(user);
    }


    @Override
    public User search(Integer userId) {
        return userMapper.selectByview(userId);
    }

    @Override
    public Integer changeAvatar(Map<String, String> map) {
        Integer userId = Integer.parseInt(map.get("userId"));
        com.jc.entity.pojo.User user = userMapper.selectById(userId);
        String userAvatar = map.get("userAvatar");

        user.setUserAvatar(userAvatar);
        return userMapper.updateById(user);
    }
}
