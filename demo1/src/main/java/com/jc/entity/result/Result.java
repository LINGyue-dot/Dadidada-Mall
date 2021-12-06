package com.jc.entity.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;


    public static Result success(String msg,Object data){
        return new Result(200,msg,data);
    };
    public static Result success(Object data){
        return new Result(200,"success",data);
    };
    public static Result fail(String msg){
        return new Result(500,msg,null);
    }
}
