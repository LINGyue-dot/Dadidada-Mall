package com.jc.service;

import com.jc.entity.pojo.Joiner;

import java.util.List;
import java.util.Map;

public interface JoinerService {
    List<Joiner> findAll();
    List<Joiner> findById(Map<String,String> map);
}
