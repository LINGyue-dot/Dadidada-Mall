package com.jc.entity.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicants {

    private Integer joinerId;
    private Integer postId;
    private String userName;
    private String userAvatar;
    private Integer batOffer;
    private Integer ballOffer;
    private String position;
}
