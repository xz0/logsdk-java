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
 * @desc:money变动日志
 */
@Slf4j
@Getter
public class LogMoneyPo extends LogBaseReasonPo {
    final String tableName = "log_money";
    /**
     * 原来的钱数
     */
    private long oldMoney;
    /**
     * 新的钱数
     */
    private long newMoney;
    /**
     * 本次变动的钱数 非负数
     */
    private long money;
    /**
     * 道具个数 本次购买道具、装备的个数 买货币时为0
     */
    private int num;
    /**
     * 增加或减少
     */
    private AddOrReduceTypeEnum addOrReduceTypeEnum;
    /**
     * 钱的类型
     * 注意：钻石货币类型必须为1，其他货币类型可自定义
     */
    private int moneyType;
    /**
     * 商品ID对应名称
     * 礼包名称及礼包中具体包含的各种物品名称都需要
     */
    private String itemIdName;
    /**
     * 商店编号
     * 区分不同的商店
     */
    private int itemType;
    /**
     * 商品项ID
     * 商店内唯一ID
     */
    private String itemId;
    /**
     * 是否属于商城购买
     * 0否1是
     */
    private int shop;

    /**
     * money日志必填字段（非商城购买行为）
     * @param channelId 渠道id
     * @param uid  uid
     * @param sequenceId 关联一次事件的唯一ID
     * @param reason 一级原因
     * @param subReason 二级原因
     * @param oldMoney 代币老的数量
     * @param newMoney 代币新的数量
     * @param num  道具个数，本次购买道具、装备的个数 买货币时为0
     * @param moneyType 代币类型
     */
    public LogMoneyPo(int channelId, String uid, String sequenceId, String reason, String subReason, long oldMoney, long newMoney, int num, int moneyType) {
        super(channelId, uid, sequenceId, reason, subReason);
        this.oldMoney = oldMoney;
        this.newMoney = newMoney;
        this.money = Math.abs(oldMoney - newMoney);
        this.num = num;
        this.addOrReduceTypeEnum = LogUtil.getAddOrReduceTypeEnum(oldMoney, newMoney);
        this.moneyType = moneyType;
        this.shop = 0;
    }

    /**
     * 商城购买行为
     * @param channelId
     * @param uid
     * @param sequenceId
     * @param reason
     * @param subReason
     * @param oldMoney
     * @param newMoney
     * @param num
     * @param moneyType
     * @param itemIdName
     * @param itemType
     * @param itemId
     */
    public LogMoneyPo(int channelId, String uid, String sequenceId, String reason, String subReason, long oldMoney, long newMoney, int num, int moneyType, String itemIdName, int itemType, String itemId) {
        this(channelId, uid, sequenceId, reason, subReason, oldMoney, newMoney, num, moneyType);
        this.shop = 1;
        this.itemIdName = itemIdName;
        this.itemType = itemType;
        this.itemId = itemId;
    }

    @Override
    public LogMoneyPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogMoneyPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogMoneyPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogMoneyPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogMoneyPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public String getLogStr(){
        String tmpStr = LogUtil.toLogFormat(this.oldMoney,this.newMoney,this.money,this.num,this.addOrReduceTypeEnum.getValue(),this.moneyType,this.itemIdName,this.itemType,this.itemId,this.shop);
        return LogUtil.toLogFormatNoFilter(tableName,super.getLogStr(),tmpStr);
    }

}
