package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.AddOrReduceTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBasePo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import com.gameley.bigData.logsdkjava.utils.StringUtil;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:装备玩法日志
 */
@Slf4j
@Getter
public class LogEquipPlaywayPo extends LogBaseReasonPo {
    final String tableName = "log_equip_playway";
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
     * 装备玩法类型
     */
    private int playType;

    /**
     * 装备玩法日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param equipType 装备类型
     * @param equipId 装备id
     * @param equipOldLevel 装备原有等级
     * @param equipNewLevel 装备新的等级
     * @param playType 装备玩法类型
     */
    public LogEquipPlaywayPo(int channelId, String uid, int equipType, int equipId, int equipOldLevel, int equipNewLevel, int playType) {
        super(channelId, uid);
        this.equipType = equipType;
        this.equipId = equipId;
        this.equipOldLevel = equipOldLevel;
        this.equipNewLevel = equipNewLevel;
        this.playType = playType;
        this.equipLevel=Math.abs(equipNewLevel-equipOldLevel);
        this.addOrReduceTypeEnum = LogUtil.getAddOrReduceTypeEnum(equipOldLevel, equipNewLevel);
    }

    public LogEquipPlaywayPo setEquipType(int equipType) {
        this.equipType = equipType;
        return this;
    }

    public LogEquipPlaywayPo setEquipId(int equipId) {
        this.equipId = equipId;
        return this;
    }

    public LogEquipPlaywayPo setEquipOldLevel(int equipOldLevel) {
        this.equipOldLevel = equipOldLevel;
        return this;
    }

    public LogEquipPlaywayPo setEquipNewLevel(int equipNewLevel) {
        this.equipNewLevel = equipNewLevel;
        return this;
    }

    public LogEquipPlaywayPo setEquipLevel(int equipLevel) {
        this.equipLevel = equipLevel;
        return this;
    }

    public LogEquipPlaywayPo setPlayType(int playType) {
        this.playType = playType;
        return this;
    }

    @Override
    public LogEquipPlaywayPo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogEquipPlaywayPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogEquipPlaywayPo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogEquipPlaywayPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogEquipPlaywayPo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogEquipPlaywayPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogEquipPlaywayPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogEquipPlaywayPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogEquipPlaywayPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogEquipPlaywayPo setPayed(int payed) {
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
        return LogUtil.toLogFormatWithFrontStr(tableName, super.getLogStr(),this.equipType,this.equipId,this.equipOldLevel,this.equipNewLevel,this.equipLevel,this.playType);
    }

}
