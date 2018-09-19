package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:道具变动日志
 */
@Slf4j
@Getter
public class LogItemPo extends LogBaseReasonPo {
    final String tableName = "log_item";
    /**
     * 道具类型
     */
    private int itemType;
    /**
     * 道具ID
     */
    private int itemId;
    /**
     * 道具原来的数量
     */
    private int oldNum;
    /**
     * 道具新的数量
     */
    private int newNum;
    /**
     * 本次变动的道具数量
     */
    private int num;

    /**
     * 道具变动日志必填参数
     * @param channelId 渠道id
     * @param uid uid
     * @param sequenceId 关联一次事件的唯一ID
     * @param reason 一级原因
     * @param subReason 二级原因
     * @param itemType 道具类型
     * @param itemId   道具id
     * @param oldNum   道具原有数量
     * @param newNum   道具新的数量
     */
    public LogItemPo(int channelId, String uid, String sequenceId, String reason, String subReason, int itemType, int itemId, int oldNum, int newNum) {
        super(channelId, uid, sequenceId, reason, subReason);
        this.itemType = itemType;
        this.itemId = itemId;
        this.oldNum = oldNum;
        this.newNum = newNum;
        this.num = Math.abs(oldNum - newNum);
        this.addOrReduceTypeEnum = LogUtil.getAddOrReduceTypeEnum(oldNum, newNum);
    }

    @Override
    public LogItemPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogItemPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogItemPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogItemPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogItemPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStrWithAddOrReduce(),this.itemType,this.itemId,this.oldNum,this.newNum,this.num);
    }

}
