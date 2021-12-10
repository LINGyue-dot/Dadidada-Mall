package com.jc.controller;


import com.github.pagehelper.PageInfo;
import com.jc.entity.pojo.Post;
import com.jc.entity.result.Result;
import com.jc.entity.vo.Applicants;
import com.jc.entity.vo.PostView;
import com.jc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public Result addPost(@RequestBody Map<String,String> map) {
        Integer postId = postService.add(map);
        if(postId==-1)return Result.fail("此时间段您已有其他活动");
        else {
            return Result.success(null);
        }
    }


    @GetMapping("/post/applicant")
    public Result getApplicant(@RequestParam("userId") Integer userId){

        List<Applicants> applicants = postService.getApplicant(userId);
        return Result.success(applicants);

    }


    @GetMapping("/post/delete")
    public Result postDelete(@RequestParam("postId") Integer postId){
        Integer state = postService.postDelete(postId);
        return Result.success(state);
    }


    @GetMapping("/post/information")
    public Result getPostInformation(@RequestParam("postId") Integer postId){


        return Result.success(postService.getPostInformation(postId));
    }


    @GetMapping("/post/home")
    public Result getPostList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){

        List<PostView> posts = postService.getPostList(pageNum,pageSize);
        PageInfo<PostView> pageInfo = new PageInfo<>(posts);
        if(pageNum!=pageInfo.getPageNum()){
            pageInfo.setList(new ArrayList<>());
        }

        return Result.success(pageInfo);
    }

    @GetMapping("/post/participant")
    public Result getParticipant(@RequestParam("postId") Integer postId){
        return Result.success(postService.getParticipant(postId));
    }

}
