package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogGuildBasePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/13 18:17
 * @desc: 公会等级日志
 */
@Slf4j
@Getter
public class LogGuildLevelPo extends LogGuildBasePo {
    final String tableName = "log_guild_level";
    /**
     * 公会原来的等级
     */
    private  int guildOldLevel;
    /**
     * 公会新的等级
     */
    private  int guildNewLevel;
    /**
     * 本次变动的等级
     */
    private  int guildLevel;

    /**
     * 公会等级日志必填字段
     * @param guildId 公会id
     * @param guildOldLevel 公会原有等级
     * @param guildNewLevel 公会新的等级
     */
    public LogGuildLevelPo(String guildId, int guildOldLevel, int guildNewLevel) {
        super(guildId);
        this.guildOldLevel = guildOldLevel;
        this.guildNewLevel = guildNewLevel;
        this.guildLevel = Math.abs(guildOldLevel-guildNewLevel);
    }

    public LogGuildLevelPo setGuildOldLevel(int guildOldLevel) {
        this.guildOldLevel = guildOldLevel;
        return this;
    }

    public LogGuildLevelPo setGuildNewLevel(int guildNewLevel) {
        this.guildNewLevel = guildNewLevel;
        return this;
    }

    public LogGuildLevelPo setGuildLevel(int guildLevel) {
        this.guildLevel = guildLevel;
        return this;
    }

    @Override
    public LogGuildLevelPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogGuildLevelPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogGuildLevelPo setDt(Date dt) {
        super.setDt(dt);
        return this;
    }

    @Override
    public LogGuildLevelPo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogGuildLevelPo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogGuildLevelPo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public LogGuildLevelPo setGuildId(String guildId) {
        super.setGuildId(guildId);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(), this.guildOldLevel,this.guildNewLevel,this.guildLevel);
    }
}
