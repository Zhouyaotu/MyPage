package com.mp.mypage;

import com.mp.mypage.user.dao.UserBaseMapper;
import com.mp.mypage.user.entity.UserBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class MypageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MypageApplication.class, args);
    }
}
