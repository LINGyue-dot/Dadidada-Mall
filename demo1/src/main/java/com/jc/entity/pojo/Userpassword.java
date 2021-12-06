package com.jc.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Userpassword {

    @TableId
    private Integer userId;

    @NotBlank(message = "密码不能为空")
    private String userPassword;

}
