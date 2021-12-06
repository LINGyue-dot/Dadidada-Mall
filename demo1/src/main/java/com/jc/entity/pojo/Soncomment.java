package com.jc.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Soncomment {
    private Integer soncommentId;
    private Timestamp postTime;
    private Integer dadcommentId;
    private Integer userId;
    private String commentContent;

}
