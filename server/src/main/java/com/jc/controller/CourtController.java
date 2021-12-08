package com.jc.controller;


import com.github.pagehelper.PageInfo;
import com.jc.entity.pojo.Court;
import com.jc.entity.result.Result;
import com.jc.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CourtController {

    @Autowired
    private CourtService courtService;

    //查询全部
    @GetMapping("/court")
    public Result findAll(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize) throws Exception{
        List<Court> data = courtService.selectByPage(pageNum,pageSize);

        PageInfo<Court> pageInfo = new PageInfo<>(data);
        return Result.success(pageInfo);
    }


    //按id查询
    @PostMapping("/find")
    public Result findById(@RequestBody Map<String,String> map){
        Court data = courtService.findById(map);
        return Result.success(data);
    }

    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Court court){
        return Result.success(courtService.update(court));
    }

    //按id删除
    @PostMapping("/delete")
    public void delete(@RequestBody Map<String,String> map){
        courtService.delete(map);
    }

    //添加
    @PostMapping("/add")
    public void findById(@RequestBody Court court){
        courtService.add(court);
    }

}
