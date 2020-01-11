package com.mp.mypage.user.servlet;

import com.mp.mypage.common.Constant;
import com.mp.mypage.common.util.FileUtil;
import com.mp.mypage.common.Result;
import com.mp.mypage.user.entity.UserBase;
import com.mp.mypage.user.entity.UserInfo;
import com.mp.mypage.user.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description  该类提供了账户模块的api
 * @author 刘鑫源
 * @time 2019/11/12
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2019/11/17
 * @version 1.0
 */
@Controller
@RequestMapping(value = "api/user")
public class AccountController {
    @Resource
    AccountService accountService;

    @Resource
    FileUtil fileUtil;

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(UserBase userBase, Model model){
        Result result = accountService.register(userBase);
        model.addAttribute("result", result);
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
        public Result login(String username, String password, Model model){
            //System.out.println(username);
            Result result = accountService.login(username, password);
            model.addAttribute("result", result);
            return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/passwords/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyPassword(@PathVariable("id")long id, String password, Model model){
        Result result = accountService.modifyPassword(id, password);
        model.addAttribute("result", result);
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/headimgs/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyHeadImg(@PathVariable("id") long id, MultipartFile file, Model model){
        Result result = fileUtil.upload(file, Constant.IMG_HEAD);
        if(result.getCode() == 0)
            result = accountService.modifyHeadImg(id, (String)result.getAttribute());
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/infos/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyUserInfo(@PathVariable("id") long id, UserInfo userInfo, Model model){
        Result result = accountService.modifyUserInfo(id, userInfo);
        model.addAttribute("reuslt", result);
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/infos/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserInfo(@PathVariable("id") long id, Model model){
        Result result = accountService.getUserInfo(id);
        model.addAttribute("result", result);
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/infos", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllUserInfo(Integer pageNum, Integer pageSize, Model model){
        System.out.println(pageNum+" "+pageSize);
        Result result =accountService.getAllUserInfo(pageNum, pageSize);
        model.addAttribute("result", result);
        return result;
    }
}
