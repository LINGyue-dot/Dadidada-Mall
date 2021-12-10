package com.jc.entity.vo;


import com.jc.entity.pojo.Dadcomment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadcommentView {

    private Integer dadcommentId;
    private Integer postId;
    private Long postTime;
    private Integer userId;
    private String commentContent;
    private String userName;
    private String userAvatar;

    public DadcommentView(Dadcomment dadcomment){
        this.dadcommentId = dadcomment.getDadcommentId();
        this.postId = dadcomment.getPostId();
        this.commentContent = dadcomment.getCommentContent();
        this.postTime = dadcomment.getPostTime().getTime();
        this.userId = dadcomment.getUserId();

    }

}
