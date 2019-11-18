package com.mp.mypage.user.servlet;

import com.mp.mypage.user.dao.UserBaseMapper;
import com.mp.mypage.user.entity.UserBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@Controller
public class TestServlet {
    @Resource
    UserBaseMapper userBaseMapper;

    @RequestMapping(value = "/insert-user")
    public void insertUserBase(HttpServletResponse response, String username, String email) throws IOException {
        UserBase userBase = new UserBase();
        userBase.setUsername(username);
        userBase.setPassword("123456");
        userBase.setAccountStatus((byte)0);
        userBase.setHeadImg("image.img");
        userBase.setAccountType((byte)0);
        userBase.setSafeEmail(email);

        userBaseMapper.insertSelective(userBase);
        response.getWriter().println("Operate Successfully!");
        response.getWriter().println(userBase);
    }
}
