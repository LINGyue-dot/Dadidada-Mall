package com.jc.controller;


import com.jc.entity.pojo.Joiner;
import com.jc.entity.result.Result;
import com.jc.service.JoinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class JoinerController {

    @Autowired
    private JoinerService joinerService;


    @PostMapping("/apply")
    public Result addParticipant(@RequestBody Joiner joiner){
        Integer state = joinerService.addApplicant(joiner);

        return Result.success(state);
    }

    @PostMapping("/join/solve")
    public Result solve(@RequestBody Map<String,String> map){
        Integer state = joinerService.solve(map);
        return Result.success(state);
    }



}
