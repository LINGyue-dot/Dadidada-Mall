package com.jc.controller;


import com.jc.entity.result.Result;
import com.jc.service.BallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BallController {

    @Autowired
    private BallService ballService;

    @GetMapping("/ball")
    public Result getBall(){
        return Result.success(ballService.getAll());
    }



}
