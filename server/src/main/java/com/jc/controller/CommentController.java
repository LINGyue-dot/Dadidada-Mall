package com.jc.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jc.entity.pojo.Court;
import com.jc.entity.pojo.Dadcomment;
import com.jc.entity.pojo.Soncomment;
import com.jc.entity.result.Result;
import com.jc.entity.vo.DadcommentView;
import com.jc.entity.vo.SoncommentView;
import com.jc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CommentController {


    @Autowired
    private CommentService commentService;


    @PostMapping("/comment_st")
    public Result addCommentSt(@RequestBody Map<String,String> map) {

        Integer state = commentService.addCommentSt(map);

        return Result.success(state);
    }

    @PostMapping("/comment_nd")
    public Result addCommentNd(@RequestBody Map<String,String> map) {

        Integer state = commentService.addCommentNd(map);

        return Result.success(state);
    }

    @GetMapping("/comment_st_get")
    public Result getCommentSt(@RequestParam("postId") Integer postId,
                          @RequestParam("pageNum") Integer pageNum,
                          @RequestParam("pageSize") Integer pageSize){
        List<DadcommentView> dadcomments = commentService.getCommentSt(postId,pageNum,pageSize);
        PageInfo<DadcommentView> pageInfo = new PageInfo<>(dadcomments);
        if(pageNum!=pageInfo.getPageNum()){
            pageInfo.setList(new ArrayList<>());
        }
        return Result.success(pageInfo);
    }

    @GetMapping("/comment_nd_get")
    public Result getCommentNd(@RequestParam("dadcommentId") Integer dadcommentId,
                               @RequestParam("pageNum") Integer pageNum,
                               @RequestParam("pageSize") Integer pageSize){
        List<SoncommentView> soncomments = commentService.getCommentNd(dadcommentId,pageNum,pageSize);
        PageInfo<SoncommentView> pageInfo = new PageInfo<>(soncomments);
        if(pageNum!=pageInfo.getPageNum()){
            pageInfo.setList(new ArrayList<>());
        }
        return Result.success(pageInfo);
    }
}
