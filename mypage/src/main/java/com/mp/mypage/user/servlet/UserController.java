package com.mp.mypage.user.servlet;

import com.mp.mypage.common.Result;
import com.mp.mypage.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @description  该类提供了用户模块的api
 * @author 刘鑫源
 * @time 2019/11/12
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2019/11/17
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/follow")
    @ResponseBody
    public Result follow(long srcId, long destId, long groupId, Model model){
        Result result = userService.follow(srcId, destId, groupId);
        model.addAttribute("result", result);
        return  result;
    }

    @CrossOrigin
    @RequestMapping(value = "/unfollow")
    @ResponseBody
    public Result unfollow(long srcId, long destId, Model model){
        Result result = userService.unfollow(srcId, destId);
        model.addAttribute("result", result);
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/modify-dest-group")
    @ResponseBody
    public Result modifyDestGroup(long srcId, long destId, long newGroupId, Model model){
        Result result = userService.modifyDestGroup(srcId, destId, newGroupId);
        model.addAttribute("result", result);
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/create-group")
    @ResponseBody
    public Result createUserGroup(@RequestParam("uid") long srcId, String groupName, Model model){
        Result result = userService.createUserGroup(srcId, groupName);
        model.addAttribute("result", result);
        return result;
    }


    @CrossOrigin
    @RequestMapping(value = "/remove-group")
    @ResponseBody
    public Result removeUserGroup(@RequestParam("gid")long groupId){
        return userService.removeUserGroup(groupId);
    }

    @CrossOrigin
    @RequestMapping(value = "/rename-group")
    @ResponseBody
    public Result renameUserGroup(@RequestParam("gid")long groupId, String newGroupName){
        return userService.renameUserGroup(groupId, newGroupName);
    }

    @CrossOrigin
    @RequestMapping(value = "/get-all-followers")
    @ResponseBody
    public Result getAllFollowersByUserId(@RequestParam("uid")long srcId){
        return userService.getAllFollowersByUserId(srcId);
    }

    @CrossOrigin
    @RequestMapping(value = "/get-all-groups")
    @ResponseBody
    public Result getAllUserGroupByUserId(@RequestParam("uid")long srcId){
        return userService.getAllUserGroupByUserId(srcId);
    }

    @CrossOrigin
    @RequestMapping(value = "/get-all-idols-gid")
    @ResponseBody
    public Result getAllIdolByGroupId(@RequestParam("gid")long groupId){
        return userService.getAllIdolByGroupId(groupId);
    }

    @CrossOrigin
    @RequestMapping(value = "/get-all-idols-uid")
    @ResponseBody
    public Result getAllIdolByUserId(@RequestParam("uid")long userId){
        return userService.getAllIdolByUserId(userId);
    }

    @CrossOrigin
    @RequestMapping(value = "/tag-label")
    @ResponseBody
    public Result tagLabel(long userId, String content, byte type){
        return userService.tagLabel(userId, content, type);
    }

    @CrossOrigin
    @RequestMapping(value = "/untag-label")
    @ResponseBody
    public Result untagLabel(long userLabelId){
        return userService.untagLabel(userLabelId);
    }

    @CrossOrigin
    @RequestMapping(value = "/get-all-labels")
    @ResponseBody
    public Result getAllLabelsByUserId(long userId){
        return userService.getAllLabelsByUserId(userId);
    }
}
