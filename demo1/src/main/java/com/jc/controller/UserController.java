package com.jc.controller;

import com.jc.entity.pojo.User;
import com.jc.entity.pojo.Userpassword;
import com.jc.entity.result.Result;
import com.jc.mapper.UserMapper;
import com.jc.service.UserPasswordService;
import com.jc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
        User data = userService.getInformation(map);
        if(data==null)return Result.fail("账号和密码不匹配");
        else return Result.success(data);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Map<String,Object> map){

        String userName = (String)map.get("userName");
        String userPassword = (String)map.get("userPassword");

        User user = new User();
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
    public Result userAdd(@RequestBody User user){
        System.out.println("-------------------------"+user.getUserSex());


        return Result.success(userService.update(user));
    }

    @GetMapping("/user/findall")
    public Result findAll() {
        List<User> data = userService.findAll();
        return Result.success(data);
    }

    @GetMapping("/user/findname")
    public Result findname(@RequestParam("userName") String userName){

        User data = userService.findname(userName);

        return Result.success(data);
    }
}
