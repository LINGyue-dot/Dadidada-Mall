package com.jc.service;

import com.jc.entity.pojo.Userpassword;

import java.util.Map;

public interface UserPasswordService {
    String find(String userName);
    void add(Userpassword userpassword);

}
