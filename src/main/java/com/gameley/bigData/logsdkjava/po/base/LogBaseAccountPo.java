package com.gameley.bigData.logsdkjava.po.base;

import com.gameley.bigData.logsdkjava.utils.DateUtil;
import com.gameley.bigData.logsdkjava.utils.LogSdPropeties;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


/**
 * @author: 王志伟
 * @date: 2018/9/11 18:33
 * @desc:账号日志基础类
 */
@Slf4j
@Getter
public class LogBaseAccountPo extends LogBasePo implements ILogPo{
    /**
     * 游戏ID
     */
    protected int gameId;

    public LogBaseAccountPo(String uuid, int channelId) {
        super(uuid, channelId);
        this.gameId= LogSdPropeties.getInstance().getGameId();
    }

    @Override
    public String getLogStr() {
        return LogUtil.toLogFormat(this.uuid, this.gameId, this.platId, this.channelId, DateUtil.dateToString(this.dt));
    }
}
