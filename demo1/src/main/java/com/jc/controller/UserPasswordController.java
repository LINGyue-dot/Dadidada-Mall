package com.jc.controller;


import com.jc.entity.result.Result;
import com.jc.service.UserPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class UserPasswordController {
    @Autowired
    private UserPasswordService userPasswordService;

    @GetMapping("/already")
    public Result isRegistered(String userName){
        Map<String, String > data = new HashMap<>();
        String registered = userPasswordService.find(userName);
        data.put("flag",registered);
        if(registered.equals("true"))
        return Result.success("用户已注册",data);
        else return Result.success("用户未注册",data);
    }
}
