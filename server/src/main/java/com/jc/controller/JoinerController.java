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
@RequestMapping("/joiner")
public class JoinerController {

    @Autowired
    private JoinerService joinerService;

    @GetMapping("/findall")
    public Result findAll(){
        List<Joiner> data = joinerService.findAll();
        return Result.success(data);
    }

    @PostMapping("/findid")
    public Result findId(@RequestBody Map<String,String> map){
        List<Joiner> data = joinerService.findById(map);

        return Result.success(data);
    }
}
