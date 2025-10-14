package com.itheima.controller;


import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public Result register(
            @Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$") String username,
            @Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$") String password) {

        User user = userService.findByUsername(username);
        if (user != null) return Result.error("用户名已存在");


        user = User.builder().username(username).password(password).build();
        userService.register(user);



        return Result.success();
    }
}
