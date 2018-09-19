package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc: 兑换码兑换日志
 */
@Slf4j
@Getter
public class LogCdkeyPo extends LogBaseRolePo {
    final String tableName = "log_cdkey";
    /**
     * 活动ID
     */
    private int actionId;
    /**
     * 玩家输入的兑换码
     */
    private String cdkey;
    /**
     * 奖品信息
     */
    private String prize;
    /**
     * 失败原因
     */
    private String failReason;

    /**
     * 兑换码兑换日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param actionId 活动id
     * @param cdkey 玩家输入的兑换码
     * @param prize 奖品信息
     * @param failReason 失败原因
     */
    public LogCdkeyPo(int channelId, String uid, int actionId, String cdkey, String prize, String failReason) {
        super(channelId, uid);
        this.actionId = actionId;
        this.cdkey = cdkey;
        this.prize = prize;
        this.failReason = failReason;
    }



    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.actionId,this.cdkey,this.prize, this.failReason);
    }


}
