package com.itheima.controller;


import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.JwtUtil;
import com.itheima.utils.Md5Util;
import com.itheima.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/register")
    public Result register(
            @Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$") String username,
            @Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$") String password) {

        User user = userService.findByUsername(username);
        if (user != null) return Result.error("用户名已存在");

        user = User.builder().username(username).password(password).build();
        userService.register(user);

        return Result.success();
    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        User user = userService.findByUsername(username);
        if (user == null) return Result.error("用户不存在或密码错误");
        password = Md5Util.getMD5String(password);
        if (!user.getPassword().equals(password)) return Result.error("用户不存在或密码错误");
        String token = jwtUtil.generateToken(username);
        return Result.success(token);
    }

    @GetMapping("/userInfo")
    public Result userInfo() {
        log.info("get /userInfo");
        String username = ThreadLocalUtil.get();
        User user = userService.findByUsername(username);
        if (user == null) return Result.error("用户不存在");

        user.setPassword(null);

        return Result.success(user);
    }
}
