package com.mp.mypage.user.servlet;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.mp.mypage.common.Result;
import com.mp.mypage.user.entity.UserBase;
import com.mp.mypage.user.entity.UserInfo;
import com.mp.mypage.user.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class AccountController {
    @Resource
    AccountService accountService;

    @RequestMapping(value = "/register")
    @ResponseBody
    public Result register(@RequestParam("user") UserBase userBase, Model model){
        Result result = accountService.register(userBase);
        model.addAttribute("result", result);
        return result;
    }

    @RequestMapping("/login")
    @ResponseBody
        public Result login(String username, String password, Model model){
            Result result = accountService.login(username, password);
            model.addAttribute("result", result);
            return result;
    }

    @RequestMapping("/modify-password")
    @ResponseBody
    public Result modifyPassword(long id, String password, Model model){
        Result result = accountService.modifyPassword(id, password);
        model.addAttribute("result", result);
        return result;
    }

    @RequestMapping("/modify-headimg")
    @ResponseBody
    public Result modifyHeadImg(long id, Model model){
        // TODO : receive img file uploaded from client
        String imgUrl = "testImg";
        Result result = accountService.modifyHeadImg(id, imgUrl);
        model.addAttribute("result", result);
        return result;
    }

    @RequestMapping("/modify-user-info")
    @ResponseBody
    public Result modifyUserInfo(long id, UserInfo userInfo, Model model){
        Result result = accountService.modifyUserInfo(id, userInfo);
        model.addAttribute("reuslt", result);
        return result;
    }

    @RequestMapping(value = "/get-user-info")
    @ResponseBody
    public Result getUserInfo(long id, Model model){
        Result result = accountService.getUserInfo(id);
        model.addAttribute("result", result);
        return result;
    }
}
