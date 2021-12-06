package com.jc.controller;


import com.jc.entity.pojo.Post;
import com.jc.entity.result.Result;
import com.jc.service.PostService;
import javafx.geometry.Pos;
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
        return Result.success(null);
    }
}
