package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.LogActionTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBaseAccountRolePo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseDevicePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:行为日志
 */
@Slf4j
@Getter
public class LogActionPo extends LogBaseAccountRolePo {
    final String tableName = "log_action";
    /**
     * 设备相关信息
     */
    private LogBaseDevicePo logBaseDevicePo = new LogBaseDevicePo();
    /**
     * 日志类型
     * 1 进区服前行为
     * 2 进区服后行为
     */
    private LogActionTypeEnum actionTypeEnum;
    /**
     * 行为类型 游戏侧自定义
     */
    private int actionType;
    /**
     * 行为编号 游戏侧自定义
     */
    private int actionNumber;
    /**
     * 长整型 扩展字段
     */
    private long g1;
    private long g2;
    private long g3;
    private long g4;
    private long g5;
    private long g6;
    /**
     * 字符串 扩展字段
     */
    private String s1;
    private String s2;
    private String s3;
    private String s4;
    private String s5;
    private String s6;

    /**
     * 行为日志必填字段
     * @param uuid uuid
     * @param channelId 渠道id
     * @param uid uid
     * @param actionTypeEnum 日志类型，详情请查看该枚举
     * @param actionType 行为类型
     * @param actionNumber 行为编号
     */
    public LogActionPo(String uuid, int channelId, String uid, LogActionTypeEnum actionTypeEnum, int actionType, int actionNumber) {
        super(uuid, channelId, uid);
        this.actionTypeEnum = actionTypeEnum;
        this.actionType = actionType;
        this.actionNumber = actionNumber;
    }

    @Override
    public LogActionPo setUuid(String uuid) {
        super.setUuid(uuid);
        return this;
    }

    @Override
    public LogActionPo setPlatId(int platId) {
        super.setPlatId(platId);
        return this;
    }

    @Override
    public LogActionPo setChannelId(int channelId) {
        super.setChannelId(channelId);
        return this;
    }

    @Override
    public LogActionPo setGameId(int gameId) {
        super.setGameId(gameId);
        return this;
    }

    @Override
    public LogActionPo setUid(String uid) {
        super.setUid(uid);
        return this;
    }

    @Override
    public LogActionPo setRegionId(int regionId) {
        super.setRegionId(regionId);
        return this;
    }

    @Override
    public LogActionPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogActionPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    public LogActionPo setLogBaseDevicePo(LogBaseDevicePo logBaseDevicePo) {
        this.logBaseDevicePo = logBaseDevicePo;
        return this;
    }


    public LogActionPo setActionTypeEnum(LogActionTypeEnum actionTypeEnum) {
        this.actionTypeEnum = actionTypeEnum;
        return this;
    }

    public LogActionPo setActionType(int actionType) {
        this.actionType = actionType;
        return this;
    }

    public LogActionPo setActionNumber(int actionNumber) {
        this.actionNumber = actionNumber;
        return this;
    }

    public LogActionPo setG1(long g1) {
        this.g1 = g1;
        return this;
    }

    public LogActionPo setG2(long g2) {
        this.g2 = g2;
        return this;
    }

    public LogActionPo setG3(long g3) {
        this.g3 = g3;
        return this;
    }

    public LogActionPo setG4(long g4) {
        this.g4 = g4;
        return this;
    }

    public LogActionPo setG5(long g5) {
        this.g5 = g5;
        return this;
    }

    public LogActionPo setG6(long g6) {
        this.g6 = g6;
        return this;
    }

    public LogActionPo setS1(String s1) {
        this.s1 = s1;
        return this;
    }

    public LogActionPo setS2(String s2) {
        this.s2 = s2;
        return this;
    }

    public LogActionPo setS3(String s3) {
        this.s3 = s3;
        return this;
    }

    public LogActionPo setS4(String s4) {
        this.s4 = s4;
        return this;
    }

    public LogActionPo setS5(String s5) {
        this.s5 = s5;
        return this;
    }

    public LogActionPo setS6(String s6) {
        this.s6 = s6;
        return this;
    }

    @Override
    public String getLogStr(){
        String tmmStr = LogUtil.toLogFormat(this.actionTypeEnum.getId(), this.actionType, this.actionNumber,this.g1,this.g2,this.g3,this.g4,this.g5,this.g6,this.s1,this.s2,this.s3,this.s4,this.s5,this.s6);
        return LogUtil.toLogFormatNoFilter(tableName,super.getLogStr(),this.logBaseDevicePo.getLogStr(),tmmStr);
    }

}
