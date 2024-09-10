package com.jaaaain.defaultsystem.controller;

import com.jaaaain.defaultsystem.entity.LoginResponse;
import com.jaaaain.defaultsystem.entity.Result;
import com.jaaaain.defaultsystem.entity.User;
import com.jaaaain.defaultsystem.mapper.UserMapper;
import com.jaaaain.defaultsystem.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("user:{}",user);
        User e = userMapper.login(user);

        //登录成功,生成令牌,下发令牌
        if (e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            claims.put("role", e.getRole());
            String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的员工信息
            log.info("登录成功,生成令牌,下发令牌:{},{}",e,jwt);
            return Result.success(new LoginResponse(e.getId(),e.getUsername(),e.getRole(),jwt));
        }

        //登录失败, 返回错误信息
        return Result.error("用户名或密码错误");
    }

}
