package com.gameley.bigData.logsdkjava.po.base;

import com.gameley.bigData.logsdkjava.utils.LogUtil;

/**
 * @author: 王志伟
 * @date: 2018/9/18 10:42
 * @desc:
 */
public class LogCustomBasePo extends LogBaseRolePo {

    private String tableName = "";

    public LogCustomBasePo(String tableName, int channelId, String uid) {
        super(channelId, uid);
        this.tableName = tableName;
    }

    @Override
    public String getLogStr() {
        return LogUtil.toLogFormatNoFilter(LogUtil.stringFilter(tableName),super.getLogStr());
    }
}
