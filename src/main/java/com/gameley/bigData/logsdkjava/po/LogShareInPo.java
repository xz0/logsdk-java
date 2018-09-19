package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:分享入流水
 */
@Slf4j
@Getter
public class LogShareInPo extends LogBaseRolePo {
    final String tableName = "log_share_in";
    /**
     * 分享点
     */
    private int type;
    /**
     * 是否是新玩家
     */
    private int newPlayer;

    /**
     * 分享入日志必参数
     * @param channelId 渠道id
     * @param uid uid
     * @param type 分享点
     * @param newPlayer  是否为新玩家 1: 是, 0: 否
     */
    public LogShareInPo(int channelId, String uid, int type, int newPlayer) {
        super(channelId, uid);
        this.type = type;
        this.newPlayer = newPlayer;
    }

    @Override
    public LogShareInPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogShareInPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogShareInPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogShareInPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogShareInPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.type, this.newPlayer);
    }

}
