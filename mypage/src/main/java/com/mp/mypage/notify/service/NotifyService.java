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
 * @lastUpdateTime 2020/01/17
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

    /**
     * 该方法用于生成通知消息
     * @param sender 发送者ID
     * @param title 通知标题
     * @param content 通知内容
     * @return 结果信息
     */
    public Result createAnnounce(long sender, String title, String content){
        NotifyAnnounce announce = new NotifyAnnounce().setSenderId(sender).setTitle(title).setContent(content)
                .setCreateTime(new Date());
        announceMapper.insert(announce);
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    /**
     * 该方法用于生成提示消息
     * @param type 提示类型
     * @param subjectType 主体类型，可取 NotifyConstant.SUBJECT_XXXX
     * @param subjectId 主体ID
     * @param action 动作，可取 NotifyConstant.ACTION_XXXX
     * @param objectType 客体类型，可取NotifiConstant.OBJECT_XXXX
     * @param objectId 客体ID
     * @return 结果信息
     */
    public Result createRemind(Integer type, Integer subjectType, Long subjectId,
                        Integer action, Integer objectType, Long objectId){
        NotifyRemind remind = new NotifyRemind().setType(type).setSubjectType(subjectType)
                .setSubjectId(subjectId).setAction(action).setObjectType(objectType)
                .setObjectId(objectId).setCreateTime(new Date());
        remindMapper.insert(remind.setType(0).setCreateTime(new Date()));
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    /**
     * 该方法用于拉取通知消息，使最新的消息进入用户消息盒子中
     * @param userId 用户ID
     * @return 操作结果, 包含未读消息数
     */
    public Result pullAnnounce(long userId){
        Date lateseTime = boxMapper.selectLatestNotifyTime(userId, NotifyConstant.TYPE_ANOUNCE);
        if(lateseTime == null)
            lateseTime = new Date(0);
        List<NotifyAnnounce> unreadAnounces = announceMapper.selectLaterThan(lateseTime);
        NotifyBox box = new NotifyBox().setUserId(userId).setRead(false).setNotifyType(NotifyConstant.TYPE_ANOUNCE);
        for(NotifyAnnounce na : unreadAnounces){
            box.setNotifyId(na.getId()).setCreateTime(na.getCreateTime());
            boxMapper.insert(box);
        }
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功")
                .addAttribute("unreadNum", unreadAnounces.size());
    }

    /**
     * 该方法用于拉取通知消息，使最新的消息进入用户消息盒子中
     * @param userId 用户ID
     * @return 操作结果, 包含未读消息数
     */
    public Result pullRemind(long userId){
        Date lateseTime = boxMapper.selectLatestNotifyTime(userId, NotifyConstant.TYPE_REMIND);
        if(lateseTime == null)
            lateseTime = new Date(0);
        System.out.println("remind:" + lateseTime);

        List<NotifyRemind> reminds = remindMapper.selectSubscribedRemind(userId, lateseTime);
        System.out.println("remind:" + reminds);
        NotifyConfig config = configMapper.selectByUserId(userId);
        List<Boolean> configVector = config.convertToConfigVector();
        NotifyBox box = new NotifyBox().setUserId(userId).setRead(false).setNotifyType(NotifyConstant.TYPE_REMIND);
        int unreadNum = 0;
        for(NotifyRemind rm : reminds){
            if(configVector.get(rm.getAction())){
                box.setNotifyId(rm.getId()).setCreateTime(rm.getCreateTime());
                boxMapper.insert(box);
                unreadNum++;
            }
        }
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功")
                .addAttribute("unreadNum", unreadNum);
    }

    /**
     * 该方法用于获取消息盒子中的消息
     * @param userId 用户ID
     * @return 操作结果，包含消息列表
     */
    public Result getNotifyBox(long userId){
        List<NotifyBox> boxes = boxMapper.selectByUserId(userId);
        int unreadNum = 0;
        for(NotifyBox nb : boxes){
            if(!nb.getRead())
                unreadNum++;
        }

        //TODO 1.分类获取 2.加工消息
        return new Result(Constant.OPERATOR_SUCCESS, "通知获取成功")
                .addAttribute("unreadNum", unreadNum)
                .addAttribute("boxes", boxes);
    }

    /**
     * 该方法用于订阅指定主体的指定动作，以便提示消息的获取
     * @param userId 用户ID
     * @param subjectType 主体类型
     * @param subjectId 主体ID
     * @param action 动作
     * @return 操作结果
     */
    public Result subcribe(Long userId, Integer subjectType, Long subjectId, Integer action){
        NotifySubcription subcription = new NotifySubcription().setUserId(userId)
                .setSubjectType(subjectType).setSubjectId(subjectId)
                .setSubjectAction(action).setCreateTime(new Date());
        subcriptionMapper.insert(subcription);
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    /**
     * 该方法用于取消订阅指定主体的指定动作，以便提示消息的获取
     * @param userId 用户ID
     * @param subjectType 主体类型
     * @param subjectId 主体ID
     * @param action 动作
     * @return 操作结果
     */
    public Result cancelSubcribe(Long userId, Integer subjectType, Long subjectId, Integer action){
        NotifySubcription subcription = new NotifySubcription().setUserId(userId).setSubjectType(subjectType).
                setSubjectId(subjectId).setSubjectAction(action);
        subcriptionMapper.deleteByDetail(userId, subjectType, subjectId, action);
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    /**
     * 该方法用于获取订阅列表
     * @param userId 用户ID
     * @return 操作结果，包含订阅列表
     */
    public Result getSubcriptions(long userId){
        List<NotifySubcription> subcriptions = subcriptionMapper.selectByUserId(userId);
        if(subcriptions == null || subcriptions.isEmpty())
            return new Result(Constant.RESULT_EMPTY, "结果为空");
        return new Result(Constant.OPERATOR_SUCCESS, "订阅表获取成功")
                .addAttribute(subcriptions);
    }

    /**
     * 该方法用于创建用户消息提醒配置
     * @param userId 用户ID
     * @return 操作结果
     */
    public Result createConfig(Long userId){
        NotifyConfig config = new NotifyConfig().setUserId(userId).setDefaultAttr();
        configMapper.insertSelective(config);
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }
    /**
     * 该方法用于修改用户消息提醒配置
     * @param userId 用户ID
     * @param config 订阅配置
     * @return 操作结果
     */
    public Result modifyConfig(long userId, NotifyConfig config){
        config.setUserId(userId);
        configMapper.updateByUserIdSelective(config);
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }

    /**
     * 该方法用于获取用户消息提醒配置
     * @param userId 用户ID
     * @return 操作结果，包含订阅配置信息
     */
    public Result getConfig(long userId){
        NotifyConfig config = configMapper.selectByUserId(userId);
        return new Result(Constant.OPERATOR_SUCCESS, "通知配置获取成功").addAttribute(config);
    }

    /**
     * 该方法用于读取消息盒子中的消息
     * @param notifyBoxId 消息在消息盒子中的ID
     * @return 操作结果
     */
    public Result readNotify(long notifyBoxId){
        boxMapper.updateByPrimaryKeySelective(new NotifyBox().setId(notifyBoxId).setRead(true));
        return new Result(Constant.OPERATOR_SUCCESS, "操作成功");
    }
}
