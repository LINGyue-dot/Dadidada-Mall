package com.jc.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamMate {

    @TableId(type = IdType.INPUT)
    @MppMultiId
    private Integer readyparticipantId;

    @TableId(type = IdType.INPUT)
    @MppMultiId
    private Integer postId;

    @TableId(type = IdType.AUTO)
    @MppMultiId
    private Integer teammateId;

}
