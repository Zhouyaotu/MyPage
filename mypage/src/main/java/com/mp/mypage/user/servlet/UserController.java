package com.mp.mypage.user.servlet;

import com.mp.mypage.common.Result;
import com.mp.mypage.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description  该类提供了用户模块的api
 * @author 刘鑫源
 * @time 2019/11/12
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2019/1/10
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    @ResponseBody
    public Result createUserGroup(@RequestParam("uid") long uid, String groupName, Model model){
        Result result = userService.createUserGroup(uid, groupName);
        model.addAttribute("result", result);
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/groups/{gid}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result removeUserGroup(@PathVariable("gid")long groupId){
        return userService.removeUserGroup(groupId);
    }

    @CrossOrigin
    @RequestMapping(value = "/groups/{gid}", method = RequestMethod.PUT)
    @ResponseBody
    public Result renameUserGroup(@PathVariable("gid")long groupId, String newGroupName){
        return userService.renameUserGroup(groupId, newGroupName);
    }

    @CrossOrigin
    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllUserGroupByUserId(@RequestParam("uid")long srcId){
        return userService.getAllUserGroupByUserId(srcId);
    }

    @CrossOrigin
    @RequestMapping(value = "/followers/{uid}", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllFollowersByUserId(@PathVariable("uid")long uid, Integer pageNum, Integer pageSize){
        return userService.getAllFollowersByUserId(uid, pageNum, pageSize);
    }

    @CrossOrigin
    @RequestMapping(value = "/idols/{uid}", method = RequestMethod.POST)
    @ResponseBody
    public Result follow(@PathVariable("uid")long uid, long idolId, long groupId, Model model){
        Result result = userService.follow(uid, idolId, groupId);
        model.addAttribute("result", result);
        return  result;
    }

    @CrossOrigin
    @RequestMapping(value = "/idols/{uid}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result unfollow(@PathVariable("uid") long uid, long idolId, Model model){
        Result result = userService.unfollow(uid, idolId);
        model.addAttribute("result", result);
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/idols/{uid}", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyDestGroup(@PathVariable("uid")long uid, long idolId, long newGroupId, Model model){
        Result result = userService.modifyDestGroup(uid, idolId, newGroupId);
        model.addAttribute("result", result);
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/idols/{uid}", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllIdolByUserId(@PathVariable("uid")long uid, Integer pageNum, Integer pageSize){
        return userService.getAllIdolByUserId(uid, pageNum, pageSize);
    }

    @CrossOrigin
    @RequestMapping(value = "/labels", method = RequestMethod.POST)
    @ResponseBody
    public Result tagLabel(long userId, String content, byte type){
        return userService.tagLabel(userId, content, type);
    }

    @CrossOrigin
    @RequestMapping(value = "/labels/{userLabelId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result untagLabel(@PathVariable("userLabelId") long userLabelId){
        return userService.untagLabel(userLabelId);
    }

    @CrossOrigin
    @RequestMapping(value = "/labels", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllLabelsByUserId(long userId){
        return userService.getAllLabelsByUserId(userId);
    }
}
