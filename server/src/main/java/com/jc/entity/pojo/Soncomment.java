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
public class Soncomment {

    @TableId(type = IdType.AUTO)
    private Integer soncommentId;


    private Timestamp postTime;
    private Integer dadcommentId;
    private Integer userId;
    private String commentContent;

}
