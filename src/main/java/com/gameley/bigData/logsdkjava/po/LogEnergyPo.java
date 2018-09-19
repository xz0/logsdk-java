package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.AddOrReduceTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:体力变动日志
 */
@Slf4j
@Getter
public class LogEnergyPo extends LogBaseReasonPo {
    final String tableName = "log_energy";
    /**
     * 玩家原来的体力
     */
    private int oldEnergy;
    /**
     * 玩家新的体力
     */
    private int newEnergy;
    /**
     * 本次变动的体力
     */
    private int energy;

    /**
     * 体力变动日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param oldEnergy 原有体力值
     * @param newEnergy 新的体力值
     */
    public LogEnergyPo(int channelId, String uid, int oldEnergy, int newEnergy) {
        super(channelId, uid);
        this.oldEnergy = oldEnergy;
        this.newEnergy = newEnergy;
        this.addOrReduceTypeEnum = LogUtil.getAddOrReduceTypeEnum(oldEnergy, newEnergy);
        this.energy=Math.abs(this.oldEnergy-this.newEnergy);
    }

    @Override
    public LogEnergyPo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogEnergyPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogEnergyPo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogEnergyPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogEnergyPo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogEnergyPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogEnergyPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogEnergyPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogEnergyPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogEnergyPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public LogEnergyPo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogEnergyPo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogEnergyPo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public LogEnergyPo setAddOrReduceTypeEnum(AddOrReduceTypeEnum addOrReduceTypeEnum) {
        super.setAddOrReduceTypeEnum(addOrReduceTypeEnum);
        return this;
    }

    public LogEnergyPo setOldEnergy(int oldEnergy) {
        this.oldEnergy = oldEnergy;
        return this;
    }

    public LogEnergyPo setNewEnergy(int newEnergy) {
        this.newEnergy = newEnergy;
        return this;
    }

    public LogEnergyPo setEnergy(int energy) {
        this.energy = energy;
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStrWithAddOrReduce(),this.oldEnergy,this.newEnergy,this.energy);
    }

}
