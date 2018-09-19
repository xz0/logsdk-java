package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.AddOrReduceTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBasePo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:装备变动日志
 */
@Slf4j
@Getter
public class LogEquipPo extends LogBaseReasonPo {
    final String tableName = "log_equip";
    /**
     * 装备类型
     */
    private int equipType;
    /**
     * 装备ID
     */
    private int equipId;
    /**
     * 装备数量
     */
    private int num;

    /**
     * 装备变动日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param sequenceId 关联一次事件的唯一id
     * @param reason 一级原因
     * @param subReason 二级原因
     * @param addOrReduceTypeEnum 增加/减少/不变，详情请查看该枚举
     * @param equipType 装备类型
     * @param equipId 装备id
     * @param num 装备数量
     */
    public LogEquipPo(int channelId, String uid, String sequenceId, String reason, String subReason, AddOrReduceTypeEnum addOrReduceTypeEnum, int equipType, int equipId, int num) {
        super(channelId, uid, sequenceId, reason, subReason, addOrReduceTypeEnum);
        this.equipType = equipType;
        this.equipId = equipId;
        this.num = num;
    }

    public LogEquipPo setEquipType(int equipType) {
        this.equipType = equipType;
        return this;
    }

    public LogEquipPo setEquipId(int equipId) {
        this.equipId = equipId;
        return this;
    }

    public LogEquipPo setNum(int num) {
        this.num = num;
        return this;
    }

    @Override
    public LogEquipPo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogEquipPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogEquipPo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogEquipPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogEquipPo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogEquipPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogEquipPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogEquipPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogEquipPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogEquipPo setPayed(int payed) {
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
    public LogBaseReasonPo setAddOrReduceTypeEnum(AddOrReduceTypeEnum addOrReduceTypeEnum) {
        super.setAddOrReduceTypeEnum(addOrReduceTypeEnum);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStrWithAddOrReduce(),this.equipType,this.equipId,this.num);
    }

}
