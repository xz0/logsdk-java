package com.gameley.bigData.logsdkjava.po.base;

import com.gameley.bigData.logsdkjava.utils.DateUtil;
import com.gameley.bigData.logsdkjava.utils.LogSdPropeties;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.Date;

/**
 * @author: 王志伟
 * @date: 2018/9/11 18:33
 * @desc:角色日志基础类
 */
@Slf4j
public class LogBaseRolePo extends LogBasePo implements ILogPo{
    /**
     * 角色注册时间  在当前区服注册时间，跟reged无关
     */
    private Date regDt;

    /**
     * 分区玩家id
     */
    protected String uid;
    /**
     * 分区id
     */
    protected int regionId;

    /**
     * 玩家等级
     */
    protected int level;
    /**
     * 注册过吗 是否在其他区服注册过
     */
    protected int reged;
    /**
     * vip等级
     */
    protected int vip;
    /**
     * 付过费吗
     */
    protected int payed;

    public LogBaseRolePo(int channelId, String uid) {
        super(channelId);
        this.uid = uid;
        this.uuid=uid;
        this.regionId = LogSdPropeties.getInstance().getRegionId();
        try {
            this.regDt = DateUtil.stringToDate("1970-01-01 00:00:00", DateUtil.DEFAULT_DATE_FAMAT);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public LogBaseRolePo(String uid, int channelId, int level) {
        this(channelId,uid);
        this.level = level;
    }

    @Override
    public LogBasePo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogBasePo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogBasePo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    public LogBaseRolePo setRegDt(Date regDt) {
        this.regDt = regDt;
        return this;
    }

    public LogBaseRolePo setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public LogBaseRolePo setRegionId(int regionId) {
        this.regionId = regionId;
        return this;
    }

    public LogBaseRolePo setLevel(int level) {
        this.level = level;
        return this;
    }

    public LogBaseRolePo setReged(int reged) {
        this.reged = reged;
        return this;
    }

    public LogBaseRolePo setVip(int vip) {
        this.vip = vip;
        return this;
    }

    public LogBaseRolePo setPayed(int payed) {
        this.payed = payed;
        return this;
    }

    public String getLogRegStr() {
        return LogUtil.toLogFormat(this.uuid, this.uid, this.platId, this.regionId, this.channelId,DateUtil.dateToString(this.dt), this.level,this.reged);
    }

    public String getLogPayStr() {
        return LogUtil.toLogFormat(this.uuid, this.uid, this.platId, this.regionId, this.channelId,DateUtil.dateToString(this.dt), DateUtil.dateToString(this.regDt), this.level,this.reged, this.vip);
    }

    @Override
    public String getLogStr() {
        return LogUtil.toLogFormat(this.uuid, this.uid, this.platId, this.regionId, this.channelId,DateUtil.dateToString(this.dt), DateUtil.dateToString(this.regDt),this.level,this.reged,this.vip,this.payed);
    }
}
