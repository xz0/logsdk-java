package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBasePo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:装备升级日志
 */
@Slf4j
@Getter
public class LogEquipLevelPo extends LogBaseReasonPo {
    final String tableName = "log_equip_level";
    /**
     * 装备类型
     */
    private int equipType;
    /**
     * 装备原来的等级
     */
    private int equipId;
    /**
     * 装备原来的等级
     */
    private int equipOldLevel;
    /**
     *装备新的等级
     */
    private int equipNewLevel;
    /**
     *本次变动的等级 非负数
     */
    private int equipLevel;

    /**
     * 装备升级日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param equipType 装备类型
     * @param equipId 装备id
     * @param equipOldLevel 装备原有等级
     * @param equipNewLevel 装备新的等级
     */
    public LogEquipLevelPo(int channelId, String uid, int equipType, int equipId, int equipOldLevel, int equipNewLevel) {
        super(channelId, uid);
        this.equipType = equipType;
        this.equipId = equipId;
        this.equipOldLevel = equipOldLevel;
        this.equipNewLevel = equipNewLevel;
        this.equipLevel = Math.abs(equipNewLevel-equipOldLevel);
        this.addOrReduceTypeEnum = LogUtil.getAddOrReduceTypeEnum(equipOldLevel, equipNewLevel);
    }

    public LogEquipLevelPo setEquipType(int equipType) {
        this.equipType = equipType;
        return this;
    }

    public LogEquipLevelPo setEquipId(int equipId) {
        this.equipId = equipId;
        return this;
    }

    public LogEquipLevelPo setEquipOldLevel(int equipOldLevel) {
        this.equipOldLevel = equipOldLevel;
        return this;
    }

    public LogEquipLevelPo setEquipNewLevel(int equipNewLevel) {
        this.equipNewLevel = equipNewLevel;
        return this;
    }

    public LogEquipLevelPo setEquipLevel(int equipLevel) {
        this.equipLevel = equipLevel;
        return this;
    }

    @Override
    public LogEquipLevelPo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogEquipLevelPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogEquipLevelPo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogEquipLevelPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogEquipLevelPo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogEquipLevelPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogEquipLevelPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogEquipLevelPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogEquipLevelPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogEquipLevelPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public LogBaseReasonPo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogBaseReasonPo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogBaseReasonPo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.equipType,this.equipId,this.equipOldLevel,this.equipNewLevel,this.equipLevel);
    }

}
