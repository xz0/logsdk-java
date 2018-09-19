package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:任务日志表
 */
@Slf4j
@Getter
public class LogTaskPo extends LogBaseReasonPo {
    final String tableName = "log_task";
    /**
     * 任务类型
     */
    private int taskType;
    /**
     * 任务ID
     */
    private int taskId;

    /**
     * 任务日志必填参数
     * @param channelId 渠道id
     * @param uid    uid
     * @param taskType  任务类型
     * @param taskId    任务id
     */
    public LogTaskPo(int channelId, String uid, int taskType, int taskId) {
        super(channelId, uid);
        this.taskType = taskType;
        this.taskId = taskId;
    }

    @Override
    public LogTaskPo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogTaskPo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogTaskPo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public LogTaskPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogTaskPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogTaskPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogTaskPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogTaskPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.taskType,this.taskId);
    }

}
