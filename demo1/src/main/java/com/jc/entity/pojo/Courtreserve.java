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
public class Courtreserve {

    @TableId(type = IdType.AUTO)
    private Integer reserveId;

    private Integer courtId;
    private Timestamp beginTime;
    private Timestamp endTime;
    private Timestamp lastTime;

}
