package com.jc.service;

import com.jc.entity.pojo.Joiner;

import java.util.List;
import java.util.Map;

public interface JoinerService {

    Integer addApplicant(Joiner joiner);

    Integer solve(Map<String,String> map);

}
