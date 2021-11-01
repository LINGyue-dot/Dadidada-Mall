package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.entity.mapper.SMapper;
import com.example.entity.pojo.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class SController {

    @Autowired
    private SMapper sMapper;

    @GetMapping("/use")
    public List<S> find(){
        return sMapper.fins();


    }
    @GetMapping("/user")
    public List<S> f(@RequestParam("name") String name){
        LambdaQueryWrapper<S> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(S::getSname,name);
        return sMapper.selectList(queryWrapper);
    }  @PostMapping("/costum")
    public List<S> relay(@RequestBody S s){
        // Map
        String sno = s.getSno();
        LambdaQueryWrapper<S> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(S::getSno,sno);
        //
        return sMapper.selectList(queryWrapper);
    }







}
