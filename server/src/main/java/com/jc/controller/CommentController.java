package com.jc.controller;


import com.jc.entity.result.Result;
import com.jc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
public class CommentController {


    @Autowired
    private CommentService dadCommentService;


    @PostMapping("/comment")
    public Result addComment(@RequestBody Map<String,String> map) {

        Integer state = dadCommentService.add(map);

        return Result.success(null);
    }
}
