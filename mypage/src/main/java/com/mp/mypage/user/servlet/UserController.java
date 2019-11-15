package com.mp.mypage.user.servlet;

import com.mp.mypage.common.Result;
import com.mp.mypage.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/follow")
    public void follow(long srcId, long destId, long groupId, Model model){
        Result result = userService.follow(srcId, destId, groupId);
        model.addAttribute("result", result);
    }

    @RequestMapping(value = "/unfollow")
    public void unfollow(long srcId, long destId, Model model){
        Result result = userService.unfollow(srcId, destId);
        model.addAttribute("result", result);
    }

    @RequestMapping(value = "modify-user-group")
    public void modifyUserGroup(long srcId, long destId, long newGroupId, Model model){
        Result result = userService.modifyUserGroup(srcId, destId, newGroupId);
        model.addAttribute("result", result);
    }

    @RequestMapping(value = "/get-all-followers")
    public void getAllFollowersByUserId(long srcId, Model model){
        Result result = userService.getAllFollowersByUserId(srcId);
        model.addAttribute("follower", result.getAttribute());
        model.addAttribute("result", result.setAttribute(null));
    }

    @RequestMapping(value = "/tag-label")
    public void tagLabel(long userId, String content, byte type, Model model){
        Result result = userService.tagLabel(userId, content, type);
        model.addAttribute("result", result);
    }

    @RequestMapping(value = "/untag-label")
    public void untagLabel(long userLabelId, Model model){
        Result result = userService.untagLabel(userLabelId);
        model.addAttribute("result", result);
    }

    @RequestMapping(value = "/get-all-labels")
    public void getAllLabelsByUserId(long userId, Model model){
        Result result = userService.getAllLabelsByUserId(userId);
        model.addAttribute("labels", result.getAttribute());
        model.addAttribute("result", result.setAttribute(null));
    }



}
