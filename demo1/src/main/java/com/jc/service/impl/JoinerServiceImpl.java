package com.jc.service.impl;


import com.jc.entity.pojo.Court;
import com.jc.entity.pojo.Joiner;
import com.jc.mapper.JoinerMapper;
import com.jc.service.JoinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JoinerServiceImpl implements JoinerService {
    @Autowired
    private JoinerMapper joinerMapper;

    @Override
    public List<Joiner> findAll(){
        List<Joiner> joiners = joinerMapper.list();
        return joiners;
    }

    @Override
    public List<Joiner> findById(Map<String,String> map){
        String joinerId = map.get("joiner_id");
        List<Joiner> joiners = joinerMapper.listId(Integer.parseInt(joinerId));
        return joiners;
    }
}
