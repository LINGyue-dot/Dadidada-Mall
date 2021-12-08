package com.jc.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ballrule {

    @TableId(type = IdType.AUTO)
    private Integer ballId;

    private String ballType;
    private Integer batNeed;
    private Integer ballNeed;

}
