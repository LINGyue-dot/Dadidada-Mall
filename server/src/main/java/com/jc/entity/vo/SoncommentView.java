package com.jc.entity.vo;

import com.jc.entity.pojo.Dadcomment;
import com.jc.entity.pojo.Soncomment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoncommentView {

    private Integer soncommentId;
    private Integer dadcommentId;
    private Long postTime;
    private Integer userId;
    private String commentContent;
    private String userName;
    private String userAvatar;

    public SoncommentView(Soncomment soncomment){
        this.dadcommentId = soncomment.getDadcommentId();
        this.soncommentId = soncomment.getSoncommentId();
        this.commentContent = soncomment.getCommentContent();
        this.postTime = soncomment.getPostTime().getTime();
        this.userId = soncomment.getUserId();

    }

}