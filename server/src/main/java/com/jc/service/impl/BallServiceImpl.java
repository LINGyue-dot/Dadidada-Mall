package com.jc.service.impl;

import com.jc.entity.pojo.Ballrule;
import com.jc.mapper.BallMapper;
import com.jc.service.BallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BallServiceImpl implements BallService {
    @Autowired
    private BallMapper ballMapper;

    @Override
    public List<Ballrule> getAll() {
        return ballMapper.selectAll();
    }
}
