package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseAccountRolePo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseDevicePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc: 打开APP开始只发一次的日志 主要为了看各步骤的流失情况
 */
@Slf4j
@Getter
public class LogAppOncePo extends LogBaseAccountRolePo {
    final String tableName = "log_app_once";
    /**
     * 设备相关信息
     */
    private LogBaseDevicePo logBaseDevicePo = new LogBaseDevicePo();
    /**
     * 行为编号
     */
    private int actionNumber;

    /**
     * 打开APP只发一次日志必填字段
     * @param uuid uuid
     * @param channelId 渠道id
     * @param actionNumber 行为编号
     */
    public LogAppOncePo(String uuid, int channelId, int actionNumber) {
        super(uuid, channelId);
        this.actionNumber = actionNumber;
    }

    @Override
    public LogAppOncePo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogAppOncePo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogAppOncePo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogAppOncePo setGameId(int gameId) {
        super.setGameId(gameId);
        return this;
    }

    @Override
    public LogAppOncePo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogAppOncePo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogAppOncePo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogAppOncePo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    public LogAppOncePo setActionNumber(int actionNumber) {
        this.actionNumber = actionNumber;
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatNoFilter(tableName,super.getLogStr(),this.logBaseDevicePo.getLogStr(),LogUtil.toLogFormat(this.actionNumber));
    }

}
