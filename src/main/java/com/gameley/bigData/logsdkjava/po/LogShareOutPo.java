package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:分享出流水
 */
@Slf4j
@Getter
public class LogShareOutPo extends LogBaseRolePo {
    final String tableName = "log_share_out";
    /**
     * 分享点
     */
    private int type;

    /**
     * 分享出必日志填参数
     * @param channelId 渠道id
     * @param uid  uid
     * @param type  分享点
     */
    public LogShareOutPo(int channelId, String uid, int type) {
        super(channelId, uid);
        this.type = type;
    }

    @Override
    public LogShareOutPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogShareOutPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogShareOutPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogShareOutPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogShareOutPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.type);
    }

}
