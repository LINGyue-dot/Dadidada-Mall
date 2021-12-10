package com.jc.entity.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participant {

    private Integer joinerId;
    private String userName;
    private String userAvatar;
    private String position;

}
