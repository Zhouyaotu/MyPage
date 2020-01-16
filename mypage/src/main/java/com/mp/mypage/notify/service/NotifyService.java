package com.mp.mypage.notify.service;

import com.mp.mypage.common.Constant;
import com.mp.mypage.common.Result;
import com.mp.mypage.notify.dao.*;
import com.mp.mypage.notify.entity.NotifyConfig;
import com.mp.mypage.notify.entity.NotifySubcription;

import javax.annotation.Resource;

public class NotifyService {
    @Resource
    NotifyAnnounceMapper notifyAnnounceMapper;

    @Resource
    NotifyBoxMapper notifyBoxMapper;

    @Resource
    NotifyConfigMapper configMapper;

    @Resource
    NotifyRemindMapper notifyRemindMapper;

    @Resource
    NotifySubcriptionMapper notifySubcriptionMapper;

    Result createAnnounce(long sender, String title, String content){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }

    Result createRemind(int subjectType, int subjectId, int action, int objectType, long objectId){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }

    Result pullAnnounce(long userId){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }

    Result pullRemind(long userId){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }

    Result getNotifyBox(long userId){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }

    Result subcribe(NotifySubcription subcription){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }

    Result cancelSubcribe(NotifySubcription subcription){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }

    Result getSubcriptions(long userId){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }

    Result modifyConfig(NotifyConfig config){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }

    Result getConfig(long userId){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }
    Result readNotify(long userId, long notifyId){
        return new Result(Constant.NOT_IMPLEMENT, "未实现");
    }



}
