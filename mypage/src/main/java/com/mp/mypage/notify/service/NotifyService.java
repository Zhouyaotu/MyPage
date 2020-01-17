package com.mp.mypage.notify.service;

import com.mp.mypage.common.Constant;
import com.mp.mypage.common.Result;
import com.mp.mypage.notify.dao.*;
import com.mp.mypage.notify.entity.*;
import com.mp.mypage.notify.util.NotifyConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description 该类提供了消息通知系统的功能方法
 * @author 刘鑫源
 * @time 2020/01/16
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2020/01/16
 * @version 1.0
 */
@Service
public class NotifyService {
    @Resource
    NotifyAnnounceMapper announceMapper;

    @Resource
    NotifyBoxMapper boxMapper;

    @Resource
    NotifyConfigMapper configMapper;

    @Resource
    NotifyRemindMapper remindMapper;

    @Resource
    NotifySubcriptionMapper subcriptionMapper;

    Result createAnnounce(long sender, String title, String content){
        NotifyAnnounce announce = new NotifyAnnounce().setSenderId(sender).setTitle(title).setContent(content)
                .setCreateTime(new Date());
        announceMapper.insert(announce);
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    Result createRemind(Integer type, Integer subjectType, Long subjectId,
                        Integer action, Integer objectType, Long objectId){
        NotifyRemind remind = new NotifyRemind().setType(type).setSubjectType(subjectType)
                .setSubjectId(subjectId).setAction(action).setObjectType(objectType)
                .setObjectId(objectId).setCreateTime(new Date());
        remindMapper.insert(remind.setType(0).setCreateTime(new Date()));
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    Result pullAnnounce(long userId){
        Date lateseTime = boxMapper.selectLatestNotifyTime(userId, NotifyConstant.TYPE_ANOUNCE);
        List<NotifyAnnounce> unreadAnounces = announceMapper.selectLaterThan(lateseTime);
        NotifyBox box = new NotifyBox().setUserId(userId).setRead(false).setNotifyType(NotifyConstant.TYPE_ANOUNCE);
        for(NotifyAnnounce na : unreadAnounces){
            box.setNotifyId(na.getId()).setCreateTime(na.getCreateTime());
            boxMapper.insert(box);
        }
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    Result pullRemind(long userId){
        Date lateseTime = boxMapper.selectLatestNotifyTime(userId, NotifyConstant.TYPE_REMIND);
        List<NotifyRemind> reminds = remindMapper.selectSubscribedRemind(userId, lateseTime);
        NotifyConfig config = configMapper.selectByUserId(userId);
        List<Boolean> configVector = config.getConfigVector();
        NotifyBox box = new NotifyBox().setUserId(userId).setRead(false).setNotifyType(NotifyConstant.TYPE_REMIND);
        for(NotifyRemind rm : reminds){
            if(configVector.get(rm.getAction())){
                box.setNotifyId(rm.getId()).setCreateTime(rm.getCreateTime());
                boxMapper.insert(box);
            }
        }
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    Result getNotifyBox(long userId){
        List<NotifyBox> boxes = boxMapper.selectByUserId(userId);
        //TODO 1.分类获取 2.加工消息
        return new Result(Constant.OPERATOR_SUCCESS, "通知获取成功")
                .addAttribute(boxes);
    }

    Result subcribe(Long userId, Integer subjectType, Long subjectId, Integer action){
        NotifySubcription subcription = new NotifySubcription().setUserId(userId)
                .setSubjectType(subjectType).setSubjectId(subjectId)
                .setSubjectAction(action).setCreateTime(new Date());
        subcriptionMapper.insert(subcription);
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    Result cancelSubcribe(Long userId, Integer subjectType, Long subjectId, Integer action){
        NotifySubcription subcription = new NotifySubcription().setUserId(userId).setSubjectType(subjectType).
                setSubjectId(subjectId).setSubjectAction(action);
        subcriptionMapper.deleteByDetail(userId, subjectType, subjectId, action);
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    Result getSubcriptions(long userId){
        List<NotifySubcription> subcriptions = subcriptionMapper.selectByUserId(userId);
        if(subcriptions == null || subcriptions.isEmpty())
            return new Result(Constant.RESULT_EMPTY, "结果为空");
        return new Result(Constant.OPERATOR_SUCCESS, "订阅表获取成功")
                .addAttribute(subcriptions);
    }

    Result modifyConfig(long userId, NotifyConfig config){
        config.setUserId(userId);
        configMapper.updateByPrimaryKeySelective(config);
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    Result getConfig(long userId){
        NotifyConfig config = configMapper.selectByUserId(userId);
        return new Result(Constant.OPERATOR_SUCCESS, "通知配置获取成功").addAttribute(config);
    }

    Result readNotify(long notifyBoxId){
        boxMapper.updateByPrimaryKeySelective(new NotifyBox().setRead(true));
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

}
