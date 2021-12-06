package com.jc.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ballrule {
    private Integer ballId;
    private String ballType;
    private Integer batNeed;
    private Integer ballNeed;

}
