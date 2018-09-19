package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.LogGuildUTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:加入退出公会日志表
 */
@Slf4j
@Getter
public class LogGuildUPo extends LogBaseReasonPo {
    final String tableName = "log_guild_u";
    /**
     * 日志类型
     *
     */
    private LogGuildUTypeEnum guildUTypeEnum;
    /**
     * 公会ID
     */
    private String guildId;

    /**
     * 加入/退出公会日志必填参数
     * @param channelId 渠道id
     * @param uid uid
     * @param guildUTypeEnum 日志类型，详情请看该枚举
     * @param guildId  公会id
     */
    public LogGuildUPo(int channelId, String uid, LogGuildUTypeEnum guildUTypeEnum, String guildId) {
        super(channelId, uid);
        this.guildUTypeEnum = guildUTypeEnum;
        this.guildId = guildId;
    }

    public LogGuildUPo setGuildUTypeEnum(LogGuildUTypeEnum guildUTypeEnum) {
        this.guildUTypeEnum = guildUTypeEnum;
        return this;
    }

    public LogGuildUPo setGuildId(String guildId) {
        this.guildId = guildId;
        return this;
    }

    @Override
    public LogGuildUPo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogGuildUPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogGuildUPo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogGuildUPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogGuildUPo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogGuildUPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogGuildUPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogGuildUPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogGuildUPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogGuildUPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public LogGuildUPo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogGuildUPo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogGuildUPo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.guildUTypeEnum.getId(),this.guildId);
    }

}
