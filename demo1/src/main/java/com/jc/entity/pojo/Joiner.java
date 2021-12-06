package com.jc.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Joiner {
    private Integer state;
    private Integer joinerId;
    private Integer postId;
    private Timestamp beginTime;
    private Timestamp endTime;
    private Integer batOffer;
    private Integer ballOffer;
    private String position;

}
