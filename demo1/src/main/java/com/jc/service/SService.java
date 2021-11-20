package com.jc.service;

import com.jc.entity.pojo.S;

import java.util.List;
import java.util.Map;

public interface SService {
    List<S> findAll();
    List<S> finds(Map<String ,String> map);
}
