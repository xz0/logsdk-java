package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.LogPayTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:充值日志
 */
@Slf4j
@Getter
public class LogPayPo extends LogBaseRolePo {
    final String tableName = "log_pay";
    /**
     * 充值类型
     * 1 代币
     * 2 月卡
     */
    private LogPayTypeEnum payTypeEnum;
    /**
     * 订单号
     */
    private String orderNumber;
    /**
     * 充值代币金额
     * 建议实际充值单位*100,以避免打折等引起小数问题，默认为人民币分
     */
    private long dPrice;
    /**
     * 充值后存量
     * 充值后玩家拥有的代币（钻石）数
     */
    private long dStoreNum;
    /**
     * 截止该笔累计充值金额
     * 跟设置的充值金额单位对应，默认为人民币分
     */
    private long totalNum;
    /**
     * 首充标志位 只有当一个区服内的玩家第一次充值时发1，其他都发0
     * 0 普通充值
     * 1 首次充值
     *
     */
    private int fPayFlag;
    /**
     * 充值渠道id 当登录渠道与充值渠道不同时需要发送，相同时发0
     */
    private int payChannelId;
    /**
     * 内购项ID
     * 游戏用的统一计费点编号，代表一个计费点，一般充值回调会透传这个参数
     */
    private String payId;
    /**
     * 内购项ID对应名称
     * 礼包名称及礼包中具体包含的各种物品名称都需要，中文，运营要能看懂
     */
    private String payIdName;
    /**
     * 本次充值代币(钻石)数量
     */
    private int dNum;
    /**
     * 充值前代币(钻石)存量
     * 充值前玩家拥有的代币（钻石）数
     */
    private long dBeforeStoreNum;

    /**
     * 充值日志必填字段
     * @param channelId 渠道id
     * @param uid  uid
     * @param payTypeEnum  充值类型，详情请看枚举
     * @param orderNumber  订单号
     * @param dPrice     充值代币金额，建议实际充值单位*100,以避免打折等引起小数问题，默认为人民币分
     * @param dStoreNum  充值后存量，充值后玩家拥有的代币（钻石）数
     * @param totalNum   首充标志位 只有当一个区服内的玩家第一次充值时发1，其他都发0
     * @param fPayFlag   充值渠道id 当登录渠道与充值渠道不同时需要发送，相同时发0
     * @param dNum       本次充值代币(钻石)数量
     * @param dBeforeStoreNum  充值前代币(钻石)存量
     */
    public LogPayPo(int channelId, String uid, LogPayTypeEnum payTypeEnum, String orderNumber, long dPrice, long dStoreNum, long totalNum, int fPayFlag, int dNum, long dBeforeStoreNum) {
        super(channelId, uid);
        this.payTypeEnum = payTypeEnum;
        this.orderNumber = orderNumber;
        this.dPrice = dPrice;
        this.dStoreNum = dStoreNum;
        this.totalNum = totalNum;
        this.fPayFlag = fPayFlag;
        this.dNum = dNum;
        this.dBeforeStoreNum = dBeforeStoreNum;
    }

    public LogPayPo setPayChannelId(int payChannelId) {
        this.payChannelId = payChannelId;
        return this;
    }

    public LogPayPo setPayId(String payId) {
        this.payId = payId;
        return this;
    }

    public LogPayPo setPayIdName(String payIdName) {
        this.payIdName = payIdName;
        return this;
    }

    @Override
    public LogPayPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogPayPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogPayPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogPayPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogPayPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public String getLogStr() {
        String tmpStr = LogUtil.toLogFormat(this.payTypeEnum.getId(), this.orderNumber, this.dPrice, this.dStoreNum,this.totalNum,this.fPayFlag,this.payChannelId,this.payId,this.payIdName,this.dNum,this.dBeforeStoreNum);
        return LogUtil.toLogFormatNoFilter(tableName,super.getLogPayStr(),tmpStr);
    }
}
