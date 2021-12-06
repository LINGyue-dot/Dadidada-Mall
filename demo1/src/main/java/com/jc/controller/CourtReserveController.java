package com.jc.controller;


import com.jc.entity.result.Result;
import com.jc.service.CourtReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@CrossOrigin
@RestController
public class CourtReserveController {

    @Autowired
    private CourtReserveService courtReserveService;

    @PostMapping("/court/reserve")
    public Result addReserve(@RequestBody Map<String,String> map){
        Integer state = courtReserveService.add(map);
        if(state==-1)return Result.fail("预约时间产生冲突");
        else return Result.success(state);
    }
}
