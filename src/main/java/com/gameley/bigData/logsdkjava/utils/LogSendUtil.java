package com.gameley.bigData.logsdkjava.utils;

import com.gameley.bigData.logsdkjava.po.*;
import com.gameley.bigData.logsdkjava.po.base.ILogPo;
import com.gameley.bigData.logsdkjava.po.base.LogCustomBasePo;
import lombok.extern.slf4j.Slf4j;

/**
 * 日志发送类
 * @author zhaoyang
 */
@Slf4j
public class LogSendUtil {
    /**
     * 发送日志入口
     * @param iLogPo
     */
    private static void sendLogEntry(ILogPo iLogPo) {
        String logInfo = iLogPo.getLogStr();
        log.info(logInfo);
        UDPUtilJava.sendLogData(logInfo);
    }

    /**
     * 发送行为日志
     * @param logActionPo
     */
    public static void sendActionLog(LogActionPo logActionPo) {
        sendLogEntry(logActionPo);
    }

    /**
     * 发送只发一次日志
     * @param logAppOncePo
     */
    public static void sendAppOnceLog(LogAppOncePo logAppOncePo) {
        sendLogEntry(logAppOncePo);
    }

    /**
     *发送在线日志
     * @param logCuPo
     */
    public static void sendCuLog(LogCuPo logCuPo) {
        sendLogEntry(logCuPo);
    }

    /**
     * 发送玩家等级日志
     * @param logLevelPo
     */
    public static void sendLevelLog(LogLevelPo logLevelPo) {
        sendLogEntry(logLevelPo);
    }

    /**
     * 发送角色登录日志
     * @param logLoginPo
     */
    public static void sendLoginLog(LogLoginPo logLoginPo) {
        sendLogEntry(logLoginPo);
    }

    /**
     * 发送渠道账号登录日志
     * @param logLoginUPo
     */
    public static void sendULoginLog(LogLoginUPo logLoginUPo) {
        sendLogEntry(logLoginUPo);
    }

    /**
     * 发送代币日志
     * @param logMoneyPo
     */
    public static void sendMoneyLog(LogMoneyPo logMoneyPo) {
        sendLogEntry(logMoneyPo);
    }

    /**
     * 发送充值日志
     * @param logPayPo
     */
    public static void sendPayLog(LogPayPo logPayPo) {
        sendLogEntry(logPayPo);
    }

    /**
     * 发送角色注册日志
     * @param logRegPo
     */
    public static void sendRegLog(LogRegPo logRegPo) { sendLogEntry(logRegPo); }

    /**
     * 发送渠道账号注册日志
     * @param logRegUPo
     */
    public static void sendURegLog(LogRegUPo logRegUPo) { sendLogEntry(logRegUPo); }

    /**
     * 发送广告流水日志
     * @param logAdVideoPo
     */
    public static void sendAdVideoLog(LogAdVideoPo logAdVideoPo) {sendLogEntry(logAdVideoPo);}

    /**
     * 发送关卡日志
     * @param logBattlePo
     */
    public static void sendBattleLog(LogBattlePo logBattlePo) {sendLogEntry(logBattlePo);}

    /**
     * 发送cdkey日志
     * @param logCdkeyPo
     */
    public static void sendCdkeyLog(LogCdkeyPo logCdkeyPo) {sendLogEntry(logCdkeyPo);}

    /**
     * 发送体力日志
     * @param logEnergyPo
     */
    public static void sendEnergyLog(LogEnergyPo logEnergyPo) {sendLogEntry(logEnergyPo);}

    public static void sendEquipDegreeLog(LogEquipDegreePo logEquipDegreePo) {sendLogEntry(logEquipDegreePo);}

    /**
     * 发送装备等级日志
     * @param logEquipLevelPo
     */
    public static void sendEquipLevelLog(LogEquipLevelPo logEquipLevelPo) {sendLogEntry(logEquipLevelPo);}

    public static void sendEquipPlaywayLog(LogEquipPlaywayPo logEquipPlaywayPo) {sendLogEntry(logEquipPlaywayPo);}

    public static void sendEquipLog(LogEquipPo logEquipPo) {sendLogEntry(logEquipPo);}

    public static void sendFriendsLog(LogFriendsPo logFriendsPo) {sendLogEntry(logFriendsPo);}

    public static void sendGamePatternLog(LogGamePatternPo logGamePatternPo) {sendLogEntry(logGamePatternPo);}

    public static void sendGuildDonateLog(LogGuildDonatePo logGuildDonatePo) {sendLogEntry(logGuildDonatePo);}

    public static void sendGuildLevelLog(LogGuildLevelPo logGuildLevelPo) {sendLogEntry(logGuildLevelPo);}

    public static void sendGuildLog(LogGuildPo logGuildPo) {sendLogEntry(logGuildPo);}

    public static void sendGuildULog(LogGuildUPo logGuildUPo) {sendLogEntry(logGuildUPo);}

    public static void sendItemLog(LogItemPo logItemPo) {sendLogEntry(logItemPo);}

    public static void sendNewTaskLog(LogNewTaskPo logNewTaskPo) {sendLogEntry(logNewTaskPo);}

    public static void sendPowerLog(LogPowerPo logPowerPo) {sendLogEntry(logPowerPo);}

    public static void sendShareInLog(LogShareInPo logShareInPo) {sendLogEntry(logShareInPo);}

    /**
     * 发送分享出日志
     * @param logShareOutPo
     */
    public static void sendShareOutLog(LogShareOutPo logShareOutPo) {sendLogEntry(logShareOutPo);}

    /**
     * 发送任务日志
     * @param logTaskPo
     */
    public static void sendTaskLog(LogTaskPo logTaskPo) {sendLogEntry(logTaskPo);}

    /**
     * 发送特性日志
     * @param logCustomBasePo
     * @param objects
     */
    public static void sendCustomLog(LogCustomBasePo logCustomBasePo, Object... objects){
        String logStr = LogUtil.toLogFormatWithFrontStr(logCustomBasePo.getLogStr(), objects);
        log.info(logStr);
        UDPUtilJava.sendLogData(logStr);
    }
}
