package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:装备进阶日志
 */
@Slf4j
@Getter
public class LogEquipDegreePo extends LogBaseReasonPo {
    final String tableName = "log_equip_degree";
    /**
     * 装备类型
     */
    private int equipType;
    /**
     * 装备原来的等级
     */
    private int equipId;
    /**
     * 装备原来的阶数
     */
    private int equipOldDegree;
    /**
     *装备新的阶数
     */
    private int equipNewDegree;
    /**
     *本次变动的阶数 非负数
     */
    private int equipDegree;

    /**
     * 装备进阶日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param equipType 装备类型
     * @param equipId 装备id
     * @param equipOldDegree 装备原有阶数
     * @param equipNewDegree 装备新的阶数
     */
    public LogEquipDegreePo(int channelId, String uid, int equipType, int equipId, int equipOldDegree, int equipNewDegree) {
        super(channelId, uid);
        this.equipType = equipType;
        this.equipId = equipId;
        this.equipOldDegree = equipOldDegree;
        this.equipNewDegree = equipNewDegree;
        this.equipDegree = Math.abs(equipOldDegree-equipNewDegree);
        this.addOrReduceTypeEnum = LogUtil.getAddOrReduceTypeEnum(equipOldDegree, equipNewDegree);
    }

    public LogEquipDegreePo setEquipDegree(int equipDegree) {
        this.equipDegree = equipDegree;
        return this;
    }

    public LogEquipDegreePo setEquipType(int equipType) {
        this.equipType = equipType;
        return this;
    }

    public LogEquipDegreePo setEquipId(int equipId) {
        this.equipId = equipId;
        return this;
    }

    public LogEquipDegreePo setEquipOldDegree(int equipOldDegree) {
        this.equipOldDegree = equipOldDegree;
        return this;
    }

    public LogEquipDegreePo setEquipNewDegree(int equipNewDegree) {
        this.equipNewDegree = equipNewDegree;
        return this;
    }

    @Override
    public LogEquipDegreePo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogEquipDegreePo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogEquipDegreePo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogEquipDegreePo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogEquipDegreePo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogEquipDegreePo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogEquipDegreePo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogEquipDegreePo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogEquipDegreePo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogEquipDegreePo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public LogEquipDegreePo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogEquipDegreePo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogEquipDegreePo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.equipType,this.equipId,this.equipOldDegree,this.equipNewDegree,this.equipDegree);
    }

}
