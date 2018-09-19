package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseDevicePo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseRolePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: 王志伟
 * @date: 2018/9/11 17:57
 * @desc:角色注册日志
 */
@Slf4j
@Getter
public class LogRegPo extends LogBaseRolePo {
    final String tableName = "log_reg";
    /**
     * 设备相关信息
     */
    private LogBaseDevicePo logBaseDevicePo = new LogBaseDevicePo();

    /**
     * 角色注册日志必填字段
     * @param channelId 渠道id
     * @param uid  uid
     */
    public LogRegPo(int channelId, String uid) {
        super(channelId, uid);
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormatNoFilter(tableName,super.getLogRegStr(),this.logBaseDevicePo.getLogStr());
    }

}
