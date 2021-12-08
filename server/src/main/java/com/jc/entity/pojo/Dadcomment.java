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
public class Dadcomment {

    @TableId(type = IdType.AUTO)
    private Integer dadcommentId;

    private Integer postId;
    private Timestamp postTime;
    private Integer userId;
    private String commentContent;

}
