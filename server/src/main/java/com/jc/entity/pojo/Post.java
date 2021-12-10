package com.jc.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @TableId(type = IdType.AUTO)
    private Integer postId;


    private Integer initiatorId;
    private Integer reserveId;
    private Timestamp postTime;
    private Timestamp beginTime;
    private Timestamp endTime;
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
}
