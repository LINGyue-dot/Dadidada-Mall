package com.jc.service.impl;

import com.github.pagehelper.PageHelper;
import com.jc.entity.pojo.Dadcomment;
import com.jc.entity.pojo.Soncomment;
import com.jc.entity.pojo.User;
import com.jc.entity.vo.DadcommentView;
import com.jc.entity.vo.SoncommentView;
import com.jc.mapper.DadCommentMapper;
import com.jc.mapper.SonCommentMapper;
import com.jc.mapper.UserMapper;
import com.jc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private DadCommentMapper dadCommentMapper;

    @Autowired
    private SonCommentMapper sonCommentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addCommentSt(Map<String, String> map) {

        Integer postId = Integer.parseInt(map.get("postId"));
        Integer userId = Integer.parseInt(map.get("userId"));
        String content = map.get("commentContent");
        Timestamp commentTime = new Timestamp(System.currentTimeMillis());

        Dadcomment dadcomment = new Dadcomment();
        dadcomment.setCommentContent(content);
        dadcomment.setPostId(postId);
        dadcomment.setUserId(userId);
        dadcomment.setPostTime(commentTime);

        return dadCommentMapper.insert(dadcomment);
    }

    @Override
    public Integer addCommentNd(Map<String, String> map) {

        Integer dadCommentId = Integer.parseInt(map.get("dadcommentId"));
        Integer userId = Integer.parseInt(map.get("userId"));
        String content = map.get("commentContent");
        Timestamp commentTime = new Timestamp(System.currentTimeMillis());

        Soncomment soncomment = new Soncomment();
        soncomment.setCommentContent(content);
        soncomment.setDadcommentId(dadCommentId);
        soncomment.setUserId(userId);
        soncomment.setPostTime(commentTime);

        return sonCommentMapper.insert(soncomment);
    }

    @Override
    public List<DadcommentView> getCommentSt(Integer postId, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Dadcomment> dadcomments = dadCommentMapper.selectByPostId(postId);
        List<DadcommentView> dadcommentViews = new ArrayList<>();
        for (Dadcomment dadcomment:dadcomments) {
            DadcommentView dadcommentView = new DadcommentView(dadcomment);
            User user = userMapper.selectById(dadcomment.getUserId());
            String userAvatar = user.getUserAvatar();
            String userName = user.getUserName();

            dadcommentView.setUserAvatar(userAvatar);
            dadcommentView.setUserName(userName);

            dadcommentViews.add(dadcommentView);
        }

        return dadcommentViews;
    }

    @Override
    public List<SoncommentView> getCommentNd(Integer dadcommentId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Soncomment> soncomments = sonCommentMapper.selectByDadCommentId(dadcommentId);
        List<SoncommentView> soncommentViews = new ArrayList<>();
        for (Soncomment soncomment:soncomments) {
            SoncommentView soncommentView = new SoncommentView(soncomment);
            User user = userMapper.selectById(soncomment.getUserId());
            String userAvatar = user.getUserAvatar();
            String userName = user.getUserName();

            soncommentView.setUserAvatar(userAvatar);
            soncommentView.setUserName(userName);

            soncommentViews.add(soncommentView);
        }

        return soncommentViews;
    }
}
