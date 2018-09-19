package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.AddOrReduceTypeEnum;
import com.gameley.bigData.logsdkjava.enums.LogGamePatternLogTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBasePo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:游戏模式日志
 */
@Slf4j
@Getter
public class LogGamePatternPo extends LogBaseReasonPo {
    final String tableName = "log_game_pattern";
    /**
     * 日志类型
     * 1 战斗开始
     * 2 战斗成功结束
     * 3 战斗失败结束
     */
    private LogGamePatternLogTypeEnum logTypeEnum;
    /**
     * 模式类型
     */
    private int patternType;
    /**
     * 模式ID
     */
    private int patternId;
    /**
     * 模式子ID 没有填0
     */
    private int patternSubId;
    /**
     * 本次闯关时间
     * 单位秒 结束时有
     */
    private int time;

    /**
     * 游戏模式日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param logTypeEnum 日志类型，详情请查看该枚举
     * @param patternType 模式类型
     * @param patternId 模式id
     * @param patternSubId 模式子id,没有填0
     */
    public LogGamePatternPo(int channelId, String uid, LogGamePatternLogTypeEnum logTypeEnum, int patternType, int patternId, int patternSubId) {
        super(channelId, uid);
        this.logTypeEnum = logTypeEnum;
        this.patternType = patternType;
        this.patternId = patternId;
        this.patternSubId = patternSubId;
    }

    /**
     * 游戏模式日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param logTypeEnum 日志类型，详情请查看该枚举
     * @param patternType 模式类型
     * @param patternId 模式id
     * @param patternSubId 模式子id,没有填0
     * @param time 本次闯关时间，结束时需要该字段，单位秒
     */
    public LogGamePatternPo(int channelId, String uid, LogGamePatternLogTypeEnum logTypeEnum, int patternType, int patternId, int patternSubId, int time) {
        this(channelId, uid, logTypeEnum, patternType, patternId, patternSubId);
        this.time=time;
    }

    public LogGamePatternPo setLogTypeEnum(LogGamePatternLogTypeEnum logTypeEnum) {
        this.logTypeEnum = logTypeEnum;
        return this;
    }

    public LogGamePatternPo setPatternType(int patternType) {
        this.patternType = patternType;
        return this;
    }

    public LogGamePatternPo setPatternId(int patternId) {
        this.patternId = patternId;
        return this;
    }

    public LogGamePatternPo setPatternSubId(int patternSubId) {
        this.patternSubId = patternSubId;
        return this;
    }

    public LogGamePatternPo setTime(int time) {
        this.time = time;
        return this;
    }

    @Override
    public LogGamePatternPo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogGamePatternPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogGamePatternPo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogGamePatternPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogGamePatternPo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogGamePatternPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogGamePatternPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogGamePatternPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogGamePatternPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogGamePatternPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public LogGamePatternPo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogGamePatternPo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogGamePatternPo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.logTypeEnum.getId(),this.patternType,this.patternId,this.patternSubId,this.time);
    }

}
