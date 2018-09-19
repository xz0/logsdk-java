package com.gameley.bigData.logsdkjava.po.base;

import com.gameley.bigData.logsdkjava.enums.LogPlatIdTypeEnum;
import com.gameley.bigData.logsdkjava.utils.DateUtil;
import com.gameley.bigData.logsdkjava.utils.LogSdPropeties;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author: 王志伟
 * @date: 2018/9/13 18:15
 * @desc:公会基础类
 */
@Slf4j
@Getter
public class LogGuildBasePo implements ILogPo{
    /**
     * 平台ID
     */
    protected int platId;
    /**
     * 分区id
     */
    protected int regionId;
    /**
     * 时间
     */
    protected Date dt = new Date();
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
     * 公会ID
     */
    private String guildId;

    public LogGuildBasePo(String guildId) {
        this.guildId = guildId;
        this.regionId= LogSdPropeties.getInstance().getRegionId();
        this.platId= LogPlatIdTypeEnum.ANDROID.getId();
    }

    public LogGuildBasePo setPlatId(int platId) {
        this.platId = platId;
        return this;
    }

    public LogGuildBasePo setRegionId(int regionId) {
        this.regionId = regionId;
        return this;
    }

    public LogGuildBasePo setDt(Date dt) {
        this.dt = dt;
        return this;
    }

    public LogGuildBasePo setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
        return this;
    }

    public LogGuildBasePo setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public LogGuildBasePo setSubReason(String subReason) {
        this.subReason = subReason;
        return this;
    }

    public LogGuildBasePo setGuildId(String guildId) {
        this.guildId = guildId;
        return this;
    }

    public String getLogStr(){
        return LogUtil.toLogFormat(this.platId, this.regionId, DateUtil.dateToString(this.dt),this.sequenceId,this.reason,this.subReason,this.guildId);
    }

}
