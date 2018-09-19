package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.LogGuildTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBasePo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:公会创建解散日志表
 */
@Slf4j
@Getter
public class LogGuildPo extends LogBaseReasonPo {
    final String tableName = "log_guild";
    /**
     * 日志类型
     *
     */
    private LogGuildTypeEnum guildTypeEnum;
    /**
     * 公会ID
     */
    private String guildId;

    /**
     * 公会创建/解散日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param guildTypeEnum 日志类型，详情请查看该枚举
     * @param guildId 公会id
     */
    public LogGuildPo(int channelId, String uid, LogGuildTypeEnum guildTypeEnum, String guildId) {
        super(channelId, uid);
        this.guildTypeEnum = guildTypeEnum;
        this.guildId = guildId;
    }

    public LogGuildPo setGuildTypeEnum(LogGuildTypeEnum guildTypeEnum) {
        this.guildTypeEnum = guildTypeEnum;
        return this;
    }

    public LogGuildPo setGuildId(String guildId) {
        this.guildId = guildId;
        return this;
    }

    @Override
    public LogGuildPo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogGuildPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogGuildPo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogGuildPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogGuildPo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogGuildPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogGuildPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogGuildPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogGuildPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogGuildPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public LogGuildPo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogGuildPo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogGuildPo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.guildTypeEnum.getId(),this.guildId);
    }

}
