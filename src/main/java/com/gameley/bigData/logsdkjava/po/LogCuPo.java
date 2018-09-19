package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.ILogPo;
import com.gameley.bigData.logsdkjava.utils.DateUtil;
import com.gameley.bigData.logsdkjava.utils.LogSdPropeties;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:在线日志
 */
@Slf4j
@Getter
public class LogCuPo implements ILogPo {
    final String tableName = "log_cu";
    /**
     * 平台ID
     */
    private int platId;
    /**
     * 区服ID
     */
    private int regionId;
    /**
     * 渠道ID
     */
    private int channelId;

    /**
     * 时间
     */
    private Date dt = new Date();
    /**
     * 付费在线人数
     */
    private int payNum;
    /**
     * 非付费在线人数
     */
    private int payNotNum;

    public LogCuPo(int channelId, int payNum, int payNotNum) {
        this.regionId = LogSdPropeties.getInstance().getRegionId();
        this.channelId = channelId;
        this.platId=LogSdPropeties.getInstance().getPlatId(channelId);
        this.payNum = payNum;
        this.payNotNum = payNotNum;
    }

    public LogCuPo setPlatId(int platId) {
        this.platId = platId;
        return this;
    }

    public LogCuPo setRegionId(int regionId) {
        this.regionId = regionId;
        return this;
    }

    public LogCuPo setChannelId(int channelId) {
        this.channelId = channelId;
        return this;
    }

    public LogCuPo setDt(Date dt) {
        this.dt = dt;
        return this;
    }

    public LogCuPo setPayNum(int payNum) {
        this.payNum = payNum;
        return this;
    }

    public LogCuPo setPayNotNum(int payNotNum) {
        this.payNotNum = payNotNum;
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormat(tableName,this.platId,this.regionId,this.channelId, DateUtil.dateToString(this.dt), this.payNum,this.payNotNum);
    }

}
