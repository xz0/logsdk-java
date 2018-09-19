package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:公会捐赠日志
 */
@Slf4j
@Getter
public class LogGuildDonatePo extends LogBaseReasonPo {
    final String tableName = "log_guild_donate";
    /**
     * 公会ID
     */
    private String guildId;

    /**
     * 公会捐赠日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param guildId 公会id
     */
    public LogGuildDonatePo(int channelId, String uid, String guildId) {
        super(channelId, uid);
        this.guildId = guildId;
    }

    public LogGuildDonatePo setGuildId(String guildId) {
        this.guildId = guildId;
        return this;
    }

    @Override
    public LogGuildDonatePo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogGuildDonatePo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogGuildDonatePo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogGuildDonatePo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogGuildDonatePo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogGuildDonatePo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogGuildDonatePo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogGuildDonatePo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogGuildDonatePo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogGuildDonatePo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public LogGuildDonatePo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogGuildDonatePo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogGuildDonatePo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.guildId);
    }

}
