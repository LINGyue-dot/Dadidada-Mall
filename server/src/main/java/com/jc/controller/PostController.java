package com.jc.controller;


import com.jc.entity.result.Result;
import com.jc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@CrossOrigin
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public Result addPost(@RequestBody Map<String,String> map) {
        Integer state = postService.add(map);
        if(state==-1)return Result.fail("此时间段您已有其他活动");
        else return Result.success(state);
    }
}
