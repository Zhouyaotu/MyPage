package com.mp.mypage.user.servlet;

import com.mp.mypage.common.Result;
import com.mp.mypage.user.entity.UserBase;
import com.mp.mypage.user.entity.UserInfo;
import com.mp.mypage.user.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class AccountController {
    @Resource
    AccountService accountService;

    @RequestMapping(value = "/register")
    public void register(@RequestParam("user") UserBase userBase, Model model){
        Result result = accountService.register(userBase);
        model.addAttribute("register-result", result);
    }

    @RequestMapping("/login")
    public void login(String username, String password, Model model){
        Result result = accountService.login(username, password);
        model.addAttribute("login-result", result);
    }

    @RequestMapping("/modify-password")
    public void modifyPassword(long id, String password, Model model){
        Result result = accountService.modifyPassword(id, password);
        model.addAttribute("modify-password-result", result);
    }

    @RequestMapping("/modify-headimg")
    public void modifyHeadImg(long id, Model model){
        // TODO : receive img file uploaded from client
        String imgUrl = "";
        Result result = accountService.modifyHeadImg(id, imgUrl);
        model.addAttribute("modify-headimg-result", result);
    }

    @RequestMapping("/modify-user-info")
    public void modifyUserInfo(long id, UserInfo userInfo, Model model){
        Result result = accountService.modifyUserInfo(id, userInfo);
        model.addAttribute("modify-user-info-reuslt", result);
    }
}
