package com.gameley.bigData.logsdkjava.po;

import com.gameley.bigData.logsdkjava.po.base.LogBaseAccountPo;
import com.gameley.bigData.logsdkjava.po.base.LogBaseDevicePo;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


/**
 * @author: 王志伟
 * @date: 2018/9/11 18:32
 * @desc:渠道账号登录日志
 */
@Slf4j
@Getter
public class LogLoginUPo extends LogBaseAccountPo {
    final String tableName = "log_login_u";
    /**
     * 设备相关信息
     */
    private LogBaseDevicePo logBaseDevicePo = new LogBaseDevicePo();

    /**
     * 渠道账号登录日志必填字段
     * @param uuid uuid
     * @param channelId 渠道id
     */
    public LogLoginUPo(String uuid, int channelId) {
        super(uuid, channelId);
    }

    @Override
    public String getLogStr() {
        return LogUtil.toLogFormatNoFilter(tableName,super.getLogStr(), this.logBaseDevicePo.getLogStr());
    }
}
