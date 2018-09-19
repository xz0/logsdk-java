package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseReasonPo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:新手任务日志表
 */
@Slf4j
@Getter
public class LogNewTaskPo extends LogBaseReasonPo {
    final String tableName = "log_new_task";
    /**
     * 步骤ID
     */
    private int taskId;
    /**
     * 跟步骤ID对应的引导顺序
     */
    private int orderId;

    /**
     * 新手任务日志必填字段
     * @param channelId 渠道id
     * @param uid uid
     * @param taskId 任务id
     * @param orderId 跟步骤ID对应的引导顺序
     */
    public LogNewTaskPo(int channelId, String uid, int taskId, int orderId) {
        super(channelId, uid);
        this.taskId = taskId;
        this.orderId = orderId;
    }

    @Override
    public LogNewTaskPo setSequenceId(String sequenceId) {
        super.setSequenceId(sequenceId);
        return this;
    }

    @Override
    public LogNewTaskPo setReason(String reason) {
        super.setReason(reason);
        return this;
    }

    @Override
    public LogNewTaskPo setSubReason(String subReason) {
        super.setSubReason(subReason);
        return this;
    }

    @Override
    public LogNewTaskPo setRegDt(Date regDt) {
        super.setRegDt(regDt);
        return this;
    }

    @Override
    public LogNewTaskPo setLevel(int level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public LogNewTaskPo setReged(int reged) {
        super.setReged(reged);
        return this;
    }

    @Override
    public LogNewTaskPo setVip(int vip) {
        super.setVip(vip);
        return this;
    }

    @Override
    public LogNewTaskPo setPayed(int payed) {
        super.setPayed(payed);
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatWithFrontStr(tableName,super.getLogStr(),this.taskId,this.orderId);
    }

}
