package com.jc.service;

import com.jc.entity.pojo.Court;

import java.util.List;
import java.util.Map;

public interface CourtService {
    List<Court> findAll();
    Court findById(Map<String ,String > map);

    Integer delete(Map<String,String > map);

    Integer add(Court court);

    List<Court> selectByPage(Integer pageNum,Integer pageSize);

    Integer update(Court court);


}
