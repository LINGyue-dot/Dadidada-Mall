package com.jc.controller;

import com.jc.entity.pojo.Userpassword;
import com.jc.entity.result.Result;
import com.jc.entity.vo.User;
import com.jc.service.UserPasswordService;
import com.jc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserPasswordService userPasswordService;


    @PostMapping("/login")
    public Result userInformation(@Validated @RequestBody Map<String,String > map){
        com.jc.entity.pojo.User data = userService.getInformation(map);
        if(data==null)return Result.fail("账号和密码不匹配");
        else return Result.success(data);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Map<String,Object> map){

        String userName = (String)map.get("userName");
        if (userName.equals(""))return Result.fail("用户名不能为空");
        String userPassword = (String)map.get("userPassword");
        if(userPassword.equals(""))return Result.fail("密码不能为空");

        com.jc.entity.pojo.User user = new com.jc.entity.pojo.User();
        user.setUserName(userName);

        Integer userId = userService.add(user);
        if(userId==-1)return Result.fail("账号已被注册！");

        Userpassword userpassword = new Userpassword();
        userpassword.setUserId(userId);
        userpassword.setUserPassword(userPassword);

        userPasswordService.add(userpassword);

        Map<String,Integer> data = new HashMap<>();
        data.put("userId",userId);

        return Result.success(data);
    }

    @PostMapping("/user/update")
    public Result userAdd(@RequestBody com.jc.entity.pojo.User user){

        return Result.success(userService.update(user));
    }


    @GetMapping("/user_search")
    public Result searchView(@RequestParam("userId") Integer userId){
        User userView = userService.search(userId);
        return Result.success(userView);
    }


    @PostMapping("/user/avatar_change")
    public Result changeAvatar(@RequestBody Map<String,String> map){

        return Result.success(userService.changeAvatar(map));
    }


}
