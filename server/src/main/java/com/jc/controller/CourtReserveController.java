package com.jc.controller;


import com.jc.entity.result.Result;
import com.jc.service.CourtReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/court/reserve_get")
    public Result getReserve(@RequestParam("userId") Integer userId){



        return Result.success(courtReserveService.getReserve(userId));
    }
}
