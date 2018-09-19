package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:等级变动日志
 */
@Slf4j
@Getter
public class LogLevelPo extends LogBaseReasonPo {
    final String tableName = "log_level";
    /**
     * 人物ID
     */
    private String heroId;
    /**
     * 玩家新等级
     */
    private int newLevel;
    /**
     * 本次变动的等级
     */
    private int num;

    /**
     * 等级变动日志（不带hero_id的构造器）
     * @param uid uid
     * @param channelId 渠道id
     * @param level 老的等级
     * @param newLevel 新的等级
     */
    public LogLevelPo(String uid, int channelId, int level, int newLevel) {
        super(uid, channelId, level);
        this.newLevel = newLevel;
        this.num = Math.abs(newLevel - level);
    }

    /**
     * 等级变动日志（带有hero_id的构造器，多角色使用）
     * @param uid uid
     * @param channelId 渠道id
     * @param level 老的等
     * @param heroId 人物id
     * @param newLevel 新的等级
     */
    public LogLevelPo(String uid, int channelId, int level, String heroId, int newLevel) {
        super(uid, channelId, level);
        this.heroId = heroId;
        this.newLevel = newLevel;
        this.num = Math.abs(newLevel - level);
    }

    @Override
    public LogLevelPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogLevelPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogLevelPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogLevelPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogLevelPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public LogLevelPo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogLevelPo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogLevelPo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public String getLogStr(){
        String tmpStr = LogUtil.toLogFormat(this.heroId,this.newLevel,this.num);
        return LogUtil.toLogFormatNoFilter(tableName,super.getLogStr(),tmpStr);
    }

}
