package com.jc.service.impl;

import com.jc.entity.pojo.Courtreserve;
import com.jc.mapper.CourtReserveMapper;
import com.jc.service.CourtReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
        Timestamp beginTime = Timestamp.valueOf(map.get("beginTime"));
        Timestamp endTime = Timestamp.valueOf(map.get("endTime"));
        Timestamp lastTime = Timestamp.valueOf(map.get("lastTime"));

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
}
