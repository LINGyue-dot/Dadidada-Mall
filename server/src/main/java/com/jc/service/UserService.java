package com.jc.service;

import com.jc.entity.vo.User;

import java.util.Map;

public interface UserService {
    com.jc.entity.pojo.User getInformation(Map<String ,String > map);


    Integer add(com.jc.entity.pojo.User user);

    Integer update(com.jc.entity.pojo.User user);

    User search(Integer userId);

    Integer changeAvatar(Map<String,String> map) ;

}
