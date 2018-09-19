package com.gameley.bigData.logsdkjava.po.base;

import com.gameley.bigData.logsdkjava.enums.AddOrReduceTypeEnum;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/12 16:05
 * @desc:带一级原因的基础类
 */
@Slf4j
@Getter
public class LogBaseReasonPo extends  LogBaseRolePo implements ILogPo{
    /**
     * 关联一次事件的唯一ID
     */
    protected String sequenceId;
    /**
     * 货币变动一级原因
     */
    protected String reason;
    /**
     * 货币变动二级原因 没有填0
     */
    protected String subReason;
    /**
     * 增加或减少
     */
    protected AddOrReduceTypeEnum addOrReduceTypeEnum;


    public LogBaseReasonPo(int channelId, String uid) {
        super(channelId, uid);
    }

    public LogBaseReasonPo(int channelId, String uid, String sequenceId, String reason, String subReason) {
        this(channelId, uid);
        this.sequenceId = sequenceId;
        this.reason = reason;
        this.subReason = subReason;
    }

    public LogBaseReasonPo(int channelId, String uid, String sequenceId, String reason, String subReason, AddOrReduceTypeEnum addOrReduceTypeEnum) {
        this(channelId, uid, sequenceId, reason, subReason);
        this.addOrReduceTypeEnum = addOrReduceTypeEnum;
    }

    public LogBaseReasonPo(int channelId, String uid, AddOrReduceTypeEnum addOrReduceTypeEnum) {
        this(channelId, uid);
        this.addOrReduceTypeEnum = addOrReduceTypeEnum;
    }

    @Override
    public LogBasePo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogBasePo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogBasePo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogBaseRolePo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogBaseRolePo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogBaseRolePo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogBaseRolePo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogBaseRolePo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogBaseRolePo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogBaseRolePo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    /**
     * 等级统计相关
     * @param uid
     * @param channelId
     * @param level
     */
    public LogBaseReasonPo(String uid, int channelId, int level) {
        super(uid, channelId, level);
    }

    public LogBaseReasonPo setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
        return this;
    }

    public LogBaseReasonPo setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public LogBaseReasonPo setSubReason(String subReason) {
        this.subReason = subReason;
        return this;
    }

    public LogBaseReasonPo setAddOrReduceTypeEnum(AddOrReduceTypeEnum addOrReduceTypeEnum) {
        this.addOrReduceTypeEnum = addOrReduceTypeEnum;
        return this;
    }

    public String getLogStrWithAddOrReduce() {
        return LogUtil.toLogFormatWithFrontStr(this.getBasicLogStr(), this.addOrReduceTypeEnum.getValue());
    }

    public String getBasicLogStr() {
        String tmpStr = LogUtil.toLogFormat(this.sequenceId, this.reason, this.subReason);
        return LogUtil.toLogFormatNoFilter(super.getLogStr(),tmpStr);
    }

    @Override
    public String getLogStr() {
        return getBasicLogStr();
    }
}
