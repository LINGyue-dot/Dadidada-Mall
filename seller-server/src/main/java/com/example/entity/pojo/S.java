package com.example.entity.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class S {
    @TableId
    private String sno;

    private String sname;

    private int status;

    private String city;


}
