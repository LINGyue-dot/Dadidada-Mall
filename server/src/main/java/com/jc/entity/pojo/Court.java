package com.jc.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Court {

    @TableId
    private Integer courtId;


    private String location;
    private String courtImg;

}
