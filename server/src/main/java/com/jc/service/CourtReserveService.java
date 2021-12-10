package com.jc.service;

import com.jc.entity.pojo.Courtreserve;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Map;

public interface CourtReserveService {
    Integer add(Map<String,String> map);

    List<Courtreserve> getReserve(Integer userId);
}
