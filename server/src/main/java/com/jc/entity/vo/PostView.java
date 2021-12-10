package com.jc.entity.vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jc.entity.pojo.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostView {

    private Integer postId;
    private Integer initiatorId;
    private Integer reserveId;
    private Long postTime;
    private Long beginTime;
    private Long endTime;
    private String postImg;
    private Integer ballId;
    private Integer batNeedNumber;
    private Integer ballNeedNumber;
    private Integer batOwnedNumber;
    private Integer ballOwnedNumber;
    private Integer peopleCurrentNumber;
    private Integer peopleMinNumber;
    private Integer peopleMaxNumber;
    private String initiatorNote;
    private String initiatorNoteDetails;
    private Integer state;
    private Boolean isDelete;

    public PostView(Post post){
        this.postId = post.getPostId();
        this.initiatorId = post.getInitiatorId();
        this.reserveId = post.getReserveId();
        this.postTime = post.getPostTime().getTime();
        this.beginTime = post.getBeginTime().getTime();
        this.endTime = post.getEndTime().getTime();
        this.postImg  = post.getPostImg();
        this.ballId = post.getBallId();
        this.batNeedNumber = post.getBatNeedNumber();
        this.ballNeedNumber = post.getBallNeedNumber();
        this.batOwnedNumber = post.getBatOwnedNumber();
        this.ballOwnedNumber = post.getBallOwnedNumber();
        this.peopleCurrentNumber = post.getPeopleCurrentNumber();
        this.peopleMinNumber = post.getPeopleMinNumber();
        this.peopleMaxNumber = post.getPeopleMaxNumber();
        this.initiatorNote = post.getInitiatorNote();
        this.initiatorNoteDetails = post.getInitiatorNoteDetails();
        this.state = post.getState();
        this.isDelete = post.getIsDelete();



    }

}
