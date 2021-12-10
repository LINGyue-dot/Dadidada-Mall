package com.jc.service.impl;

import com.jc.entity.pojo.Courtreserve;
import com.jc.mapper.CourtReserveMapper;
import com.jc.service.CourtReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourtReserveServiceImpl implements CourtReserveService {

    @Autowired
    private CourtReserveMapper courtReserveMapper;

    @Override
    public Integer add(Map<String,String> map) {
        Courtreserve courtReserve =  new Courtreserve();
        Integer courtId = Integer.parseInt(map.get("courtId"));
        Timestamp beginTime = new Timestamp(Long.parseLong(map.get("beginTime")));
        Timestamp endTime = new Timestamp(Long.parseLong(map.get("endTime")));
        Timestamp lastTime = new Timestamp(Long.parseLong(map.get("lastTime")));

        List<Courtreserve> courtreserves = courtReserveMapper.selectByCourtId(courtId);
        for (Courtreserve courtreserve:courtreserves) {
            if (!(beginTime.getTime()>=courtreserve.getEndTime().getTime()||endTime.getTime()<=courtreserve.getBeginTime().getTime()))return -1;
        }

        courtReserve.setCourtId(courtId);
        courtReserve.setBeginTime(beginTime);
        courtReserve.setEndTime(endTime);
        courtReserve.setLastTime(lastTime);

        return courtReserveMapper.insert(courtReserve);
    }

    @Override
    public List<Courtreserve> getReserve(Integer userId) {

        Map<String,Object> map = new HashMap<>();
        map.put("user_id",userId);

        List<Courtreserve> courtreserves = courtReserveMapper.selectByMap(map);

        return courtreserves;
    }
}
