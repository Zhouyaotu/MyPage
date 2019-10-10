package com.mp.mypage.controller;

import com.mp.mypage.entity.User;
import com.mp.mypage.result.Result;
import com.mp.mypage.service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.Objects;

@Controller
public class LoginController {
    @Resource
    UserLoginService userLoginService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userLoginService.get(username, requestUser.getPassword());
        if (null == user) {
            System.out.println(user);
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
