package com.jc.service.impl;

import com.jc.entity.pojo.S;
import com.jc.mapper.SMapper;
import com.jc.service.SService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SServiceImpl implements SService {

    @Autowired
    private SMapper sMapper;

    @Override
    public List<S> findAll() {
        List<S> s = sMapper.list();
        return s;
    }
    @Override
    public List<S> finds(Map<String,String> map){
        String sno = map.get("sno");
        List<S> s = sMapper.list1(sno);

        return s;
    }
}
