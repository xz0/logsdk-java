package com.gameley.bigData.logsdkjava.po.base;

import com.gameley.bigData.logsdkjava.utils.LogSdPropeties;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author: 王志伟
 * @date: 2018/9/11 18:33
 * @desc:基础类
 */
@Slf4j
@Getter
public class LogBasePo implements ILogPo{
    /**
     * 渠道账号唯一id
     */
    protected String uuid;
    /**
     * 平台ID
     */
    protected int platId;
    /**
     * 渠道ID
     */
    protected int channelId;

    /**
     * 时间
     */
    protected Date dt = new Date();

    public LogBasePo(String uuid, int channelId) {
        this(channelId);
        this.uuid = uuid;
    }

    public LogBasePo(int channelId) {
        this.channelId = channelId;
        this.platId= LogSdPropeties.getInstance().getPlatId(channelId);
    }

    public LogBasePo setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public LogBasePo setPlatId(int platId) {
        this.platId = platId;
        return this;
    }

    public LogBasePo setChannelId(int channelId) {
        this.channelId = channelId;
        return this;
    }

    @Override
    public String getLogStr() {
        return "";
    }
}
