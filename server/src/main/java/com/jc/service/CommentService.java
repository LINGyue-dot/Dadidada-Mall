package com.jc.service;

import com.jc.entity.pojo.Dadcomment;
import com.jc.entity.pojo.Soncomment;
import com.jc.entity.vo.DadcommentView;
import com.jc.entity.vo.SoncommentView;

import java.util.List;
import java.util.Map;

public interface CommentService {

    Integer addCommentSt(Map<String,String> map);

    Integer addCommentNd(Map<String,String> map);

    List<DadcommentView> getCommentSt(Integer postId, Integer pageNum, Integer pageSize);

    List<SoncommentView> getCommentNd(Integer postId, Integer pageNum, Integer pageSize);

}
