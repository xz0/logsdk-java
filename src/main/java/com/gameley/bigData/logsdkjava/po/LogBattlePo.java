package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.LogGamePatternLogTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc: 关卡日志表
 */
@Slf4j
@Getter
public class LogBattlePo extends LogBaseReasonPo {
    final String tableName = "log_battle";
    /**
     * 日志类型
     * 1 战斗开始
     * 2 战斗成功结束
     * 3 战斗失败结束
     */
    private LogGamePatternLogTypeEnum logTypeEnum;
    /**
     * 关卡类型
     */
    private int battleType;
    /**
     * 关卡ID
     */
    private int battleId;
    /**
     * 本次闯关时间
     * 单位秒 结束时有
     */
    private int time;

    /**
     * 关卡日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param logTypeEnum 日志类型，详情请查看该枚举
     * @param battleType 关卡类型
     * @param battleId 关卡id
     */
    public LogBattlePo(int channelId, String uid, LogGamePatternLogTypeEnum logTypeEnum, int battleType, int battleId) {
        super(channelId, uid);
        this.logTypeEnum = logTypeEnum;
        this.battleType = battleType;
        this.battleId = battleId;
    }

    /**
     * 关卡日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param logTypeEnum 日志类型，详情请查看该枚举
     * @param battleType 关卡类型
     * @param battleId 关卡id
     * @param time 本次战斗时间,结束时有
     */
    public LogBattlePo(int channelId, String uid, LogGamePatternLogTypeEnum logTypeEnum, int battleType, int battleId, int time) {
        this(channelId,uid,logTypeEnum,battleType,battleId);
        this.time = time;
    }

    @Override
    public LogBattlePo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogBattlePo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogBattlePo setChannelId(int channelId) {
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

    @Override
    public LogBattlePo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogBattlePo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogBattlePo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;

    }

    public LogBattlePo setLogTypeEnum(LogGamePatternLogTypeEnum logTypeEnum) {
        this.logTypeEnum = logTypeEnum;
        return this;
    }

    public LogBattlePo setBattleType(int battleType) {
        this.battleType = battleType;
        return this;
    }

    public LogBattlePo setBattleId(int battleId) {
        this.battleId = battleId;
        return this;
    }

    public LogBattlePo setTime(int time) {
        this.time = time;
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.logTypeEnum.getId(),this.battleType,this.battleId,this.time);
    }

}
