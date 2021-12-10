package com.jc.service;

import com.jc.entity.pojo.Ballrule;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

public interface BallService {
    List<Ballrule> getAll();
}
