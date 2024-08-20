package com.tianyuan.controller;

import com.tianyuan.service.LoginService;
import com.tianyuan.utils.ResponseResult;
import com.tianyuan.vo.LoginVo;
import jakarta.annotation.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public ResponseResult login(@RequestBody LoginVo loginVo) {
        //to do parameter checking  also we can use JSR303
        if (Objects.isNull(loginVo) || !StringUtils.hasText(loginVo.getUsername()) || !StringUtils.hasText(loginVo.getPassword())) {
            return new ResponseResult(500, "参数错误");
        }
        Boolean flag = loginService.login(loginVo);
        if (flag) {
            return new ResponseResult(200, "登录成功");
        } else {
            return new ResponseResult(500, "登录失败");
        }
    }
}
