package com.jc.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Joiner {
    private Integer state;
    private Integer postId;

    private Timestamp beginTime;
    private Timestamp endTime;

    @TableId(type = IdType.AUTO)
    @MppMultiId
    private Integer joinerId;
    @MppMultiId
    private Integer batOffer;
    private Integer ballOffer;
    private String position;

}
