package com.gameley.bigData.logsdkjava.po.base;

import com.gameley.bigData.logsdkjava.utils.DateUtil;
import com.gameley.bigData.logsdkjava.utils.LogSdPropeties;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


/**
 * @author: 王志伟
 * @date: 2018/9/11 18:33
 * @desc:基础类
 */
@Slf4j
@Getter
public class LogBaseAccountRolePo extends LogBasePo implements ILogPo{
    /**
     * 游戏ID
     */
    protected int gameId;
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
     * 注册过吗
     */
    protected int reged;

    public LogBaseAccountRolePo(String uuid, int channelId) {
        super(uuid, channelId);
        this.gameId= LogSdPropeties.getInstance().getGameId();
        this.regionId=LogSdPropeties.getInstance().getRegionId();
    }

    public LogBaseAccountRolePo(int channelId, String uid) {
        super(channelId);
        this.uid = uid;
    }

    public LogBaseAccountRolePo(String uuid, int channelId, String uid) {
        this(uuid,channelId);
        this.uid = uid;

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

    public LogBaseAccountRolePo setGameId(int gameId) {
        this.gameId = gameId;
        return this;
    }

    public LogBaseAccountRolePo setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public LogBaseAccountRolePo setRegionId(int regionId) {
        this.regionId = regionId;
        return this;
    }

    public LogBaseAccountRolePo setLevel(int level) {
        this.level = level;
        return this;
    }

    public LogBaseAccountRolePo setReged(int reged) {
        this.reged = reged;
        return this;
    }


    @Override
    public String getLogStr(){
        return LogUtil.toLogFormat(this.uuid,this.uid,this.gameId,this.platId,this.regionId,this.channelId, DateUtil.dateToString(this.dt),this.level,this.reged);
    }
}
