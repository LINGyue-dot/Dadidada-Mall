package com.jc.service.impl;

import com.github.pagehelper.PageHelper;
import com.jc.entity.pojo.Court;
import com.jc.mapper.CourtMapper;
import com.jc.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourtServiceImpl implements CourtService {

    @Autowired
    private CourtMapper courtMapper;

    @Override
    public List<Court> findAll() {
        return courtMapper.selectAll();
    }

    @Override
    public Court findById(Map<String ,String > map){
        Integer id = Integer.parseInt(map.get("courtId"));
        return courtMapper.selectById(id);
    }

    @Override
    public Integer delete(Map<String,String> map){
        Integer id = Integer.parseInt(map.get("courtId"));
        return courtMapper.deleteById(id);
    }

    @Override
    public Integer add(Court court){
        return courtMapper.insert(court);
    }

    @Override
    public Integer update(Court court){
        return courtMapper.updateById(court);
    }

    @Override
    public List<Court> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Court> courts = courtMapper.selectAll();
        return courts;
    }
}
