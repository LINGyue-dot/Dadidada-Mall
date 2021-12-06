package com.jc.service;

import com.jc.entity.pojo.Court;
import com.jc.entity.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getInformation(Map<String ,String > map);

    List<User> findAll();

    Integer add(User user);

    Integer update(User user);
    User findname(String name);
    Integer selectId(String name);

}
