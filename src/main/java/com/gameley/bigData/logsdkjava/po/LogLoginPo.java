package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.enums.LogLoginTypeEnum;
import com.gameley.bigData.logsdkjava.po.base.LogBaseDevicePo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:角色登录日志
 */
@Slf4j
@Getter
public class LogLoginPo extends LogBaseRolePo {
    final String tableName = "log_login";
    /**
     * 设备相关信息
     */
    private LogBaseDevicePo logBaseDevicePo = new LogBaseDevicePo();
    /**
     * 登录类型
     * 0 登出
     * 1 登入
     */
    private LogLoginTypeEnum loginTypeEnum;
    /**
     * 玩家好友数量
     */
    private int friendsNum;
    /**
     * 本次登录在线时间 退出时有,秒为单位
     */
    private int online;
    /**
     * 玩家战力
     */
    private long power;
    /**
     * 体力
     */
    private int energy;
    /**
     * 公会ID 没有公会填0
     */
    private String guildId;
    /**
     * 角色昵称
     * 注意昵称中不能有|
     */
    private String roleName;

    /**
     * 最基本的必填字段,如果还需要其它字段(online、guild_id、role_name)请自由组合
     * @param channelId 渠道id
     * @param uid uid
     * @param loginTypeEnum 登录类型，具体请看该枚举
     */
    public LogLoginPo(int channelId, String uid, LogLoginTypeEnum loginTypeEnum, Date regDt) {
        super(channelId, uid);
        this.loginTypeEnum = loginTypeEnum;
        this.setRegDt(regDt);
    }

    /**
     * 在基本的必填字段基础上增加了online、guild_id、role_name
     * @param channelId 渠道id
     * @param uid uid
     * @param loginTypeEnum 登录类型，具体请看该枚举
     * @param online 本次登录在线时间 退出时有,单位为秒
     * @param guildId 公会ID 没有公会填0
     * @param roleName 角色昵称，注意昵称中不能有竖线 |
     */
    public LogLoginPo(int channelId, String uid, LogLoginTypeEnum loginTypeEnum, int online, String guildId, String roleName) {
        super(channelId, uid);
        this.loginTypeEnum = loginTypeEnum;
        this.online = online;
        this.guildId = guildId;
        this.roleName = LogUtil.stringFilterAll(roleName);
    }

    public LogLoginPo setFriendsNum(int friendsNum) {
        this.friendsNum = friendsNum;
        return this;
    }

    public LogLoginPo setOnline(int online) {
        this.online = online;
        return this;
    }

    public LogLoginPo setPower(long power) {
        this.power = power;
        return this;
    }

    public LogLoginPo setEnergy(int energy) {
        this.energy = energy;
        return this;
    }

    public LogLoginPo setGuildId(String guildId) {
        this.guildId = guildId;
        return this;
    }

    public LogLoginPo setRoleName(String roleName) {
        this.roleName = LogUtil.stringFilterAll(roleName);
        return this;
    }

    @Override
    public LogLoginPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogLoginPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogLoginPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogLoginPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogLoginPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public String getLogStr(){
        String tmpStr = LogUtil.toLogFormat(this.loginTypeEnum.getId(), this.friendsNum, this.online, this.power, this.energy, this.guildId, this.roleName);
        return LogUtil.toLogFormatNoFilter(tableName,super.getLogStr(),this.logBaseDevicePo.getLogStr(), tmpStr);
    }

}
