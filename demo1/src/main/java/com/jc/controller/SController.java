package com.jc.controller;

import com.jc.entity.pojo.S;
import com.jc.entity.result.Result;
import com.jc.service.SService;
import com.jc.service.impl.SServiceImpl;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/hello")
public class SController {


    @Autowired
    private SService service;

    @GetMapping("/findall")
    public Result findAll(){
        List<S> data = service.findAll();
        return Result.success(data);
    }

    @PostMapping("/finds")
    public Result finds(@RequestBody Map<String,String> map){
        List<S> data = service.finds(map);
        return Result.success(data);
    }

}
