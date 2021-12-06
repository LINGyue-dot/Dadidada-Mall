package com.jc.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dadcomment {
    private Integer dadcommentId;
    private Timestamp postTime;
    private Integer postId;
    private Integer userId;
    private String commentContent;

}
