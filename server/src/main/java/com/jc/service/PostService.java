package com.jc.service;

import com.jc.entity.pojo.Joiner;
import com.jc.entity.pojo.Post;
import com.jc.entity.vo.Applicants;
import com.jc.entity.vo.Participant;
import com.jc.entity.vo.PostView;
import javafx.geometry.Pos;

import java.util.List;
import java.util.Map;

public interface PostService {
    Integer add(Map<String,String> map);

    List<Applicants> getApplicant(Integer userId);

    Integer postDelete(Integer postId);

    List<PostView> getPostList(Integer pageNum, Integer pageSize);

    PostView getPostInformation(Integer postId);


    List<Participant> getParticipant(Integer postId);
}
