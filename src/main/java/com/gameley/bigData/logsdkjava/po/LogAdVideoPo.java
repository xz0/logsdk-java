package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.LogAdVideoActionTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:广告视频流水
 */
@Slf4j
@Getter
public class LogAdVideoPo extends LogBaseRolePo {
    final String tableName = "log_ad_video";
    /**
     * 视频触发点
     */
    private int type;
    /**
     * 具体动作
     */
    private LogAdVideoActionTypeEnum actionTypeEnum;

    /**
     * 广告视频日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param type 视频触发点
     * @param actionTypeEnum 具体动作，详情请查看该枚举
     */
    public LogAdVideoPo(int channelId, String uid, int type, LogAdVideoActionTypeEnum actionTypeEnum) {
        super(channelId, uid);
        this.type = type;
        this.actionTypeEnum = actionTypeEnum;
    }

    @Override
    public LogAdVideoPo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogAdVideoPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogAdVideoPo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogAdVideoPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogAdVideoPo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogAdVideoPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogAdVideoPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogAdVideoPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogAdVideoPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogAdVideoPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    public LogAdVideoPo setType(int type) {
        this.type = type;
        return this;
    }

    public LogAdVideoPo setActionTypeEnum(LogAdVideoActionTypeEnum actionTypeEnum) {
        this.actionTypeEnum = actionTypeEnum;
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.type,this.actionTypeEnum.getId());
    }

}
