package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.AddOrReduceTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBasePo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:好友变动日志
 */
@Slf4j
@Getter
public class LogFriendsPo extends LogBaseRolePo {
    final String tableName = "log_friends";
    /**
     * 增加或减少
     */
    private AddOrReduceTypeEnum addOrReduceTypeEnum;
    /**
     * 玩家原来的好友数量
     */
    private int oldFriendsNum;
    /**
     * 玩家新的好友数量
     */
    private int newFriendsNum;
    /**
     * 本次变动的好友数量
     */
    private int friendsNum;
    /**
     * 好友类型
     */
    private int type;

    /**
     * 好友变动日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param oldFriendsNum 原有好友数量
     * @param newFriendsNum 新的好友数量
     * @param type 好友类型
     */
    public LogFriendsPo(int channelId, String uid, int oldFriendsNum, int newFriendsNum, int type) {
        super(channelId, uid);
        this.oldFriendsNum = oldFriendsNum;
        this.newFriendsNum = newFriendsNum;
        this.type = type;
        this.addOrReduceTypeEnum = LogUtil.getAddOrReduceTypeEnum(oldFriendsNum, newFriendsNum);
        this.friendsNum= Math.abs(oldFriendsNum-newFriendsNum);
    }

    public LogFriendsPo setAddOrReduceTypeEnum(AddOrReduceTypeEnum addOrReduceTypeEnum) {
        this.addOrReduceTypeEnum = addOrReduceTypeEnum;
        return this;
    }

    public LogFriendsPo setOldFriendsNum(int oldFriendsNum) {
        this.oldFriendsNum = oldFriendsNum;
        return this;
    }

    public LogFriendsPo setNewFriendsNum(int newFriendsNum) {
        this.newFriendsNum = newFriendsNum;
        return this;
    }

    public LogFriendsPo setFriendsNum(int friendsNum) {
        this.friendsNum = friendsNum;
        return this;
    }

    public LogFriendsPo setType(int type) {
        this.type = type;
        return this;
    }

    @Override
    public LogFriendsPo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogFriendsPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogFriendsPo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogFriendsPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogFriendsPo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogFriendsPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogFriendsPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogFriendsPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogFriendsPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogFriendsPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public String getLogStr(){
        String tmpStr = LogUtil.toLogFormat(this.addOrReduceTypeEnum.getValue(),this.oldFriendsNum,this.newFriendsNum,this.friendsNum,this.type);
        String s = LogUtil.toLogFormatNoFilter(tableName,super.getLogStr(),tmpStr);
        return s;
    }

}
