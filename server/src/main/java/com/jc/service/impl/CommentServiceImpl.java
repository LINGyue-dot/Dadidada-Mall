package com.jc.service.impl;

import com.jc.entity.pojo.Dadcomment;
import com.jc.mapper.DadCommentMapper;
import com.jc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private DadCommentMapper dadCommentMapper;


    @Override
    public Integer add(Map<String, String> map) {

        Integer postId = Integer.parseInt(map.get("postId"));
        Integer userId = Integer.parseInt(map.get("userId"));
        String content = map.get("commentContent");
        Timestamp commentTime = Timestamp.valueOf(LocalDateTime.now());

        Dadcomment dadcomment = new Dadcomment();
        dadcomment.setCommentContent(content);
        dadcomment.setPostId(postId);
        dadcomment.setUserId(userId);
        dadcomment.setPostTime(commentTime);

        return dadCommentMapper.insert(dadcomment);
    }
}
