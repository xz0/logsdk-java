package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.AddOrReduceTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:战力变动日志
 */
@Slf4j
@Getter
public class LogPowerPo extends LogBaseReasonPo {
    final String tableName = "log_power";
    /**
     * 玩家原来的战力
     */
    private long oldPower;
    /**
     * 玩家新的战力
     */
    private long newPower;
    /**
     * 本次变动的战力
     */
    private long power;


    /**
     * 战力变动日志必填参数构造器
     * @param channelId 渠道id
     * @param uid uid
     * @param oldPower 老的数量
     * @param newPower 新的数量
     */
    public LogPowerPo(int channelId, String uid, long oldPower, long newPower) {
        super(channelId, uid);
        this.oldPower = oldPower;
        this.newPower = newPower;
        this.power = Math.abs(newPower - oldPower);
        this.addOrReduceTypeEnum = LogUtil.getAddOrReduceTypeEnum(oldPower, newPower);
    }

    @Override
    public LogPowerPo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogPowerPo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogPowerPo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public LogPowerPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogPowerPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogPowerPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogPowerPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogPowerPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStrWithAddOrReduce(),this.oldPower,this.newPower,this.power);
    }

}
