package com.gameley.bigData.logsdkjava.utils;

import com.gameley.bigData.logsdkjava.enums.*;
import com.gameley.bigData.logsdkjava.po.*;
import com.gameley.bigData.logsdkjava.po.base.LogCustomBasePo;
import org.junit.Test;

import java.util.Date;

/**
 * @author: 王志伟
 * @date: 2018/9/17 15:56
 * @desc:
 */
public class LogSendUtilTest {

    String uuid = "uuid";
    String uid = "uid";
    int channelId = 2006603;
    String reason = "1";
    String subreason = "0";

    @Test
    public void sendActionLogTest(){
        LogActionPo logActionPo = new LogActionPo(uuid,channelId,"", LogActionTypeEnum.region_before, 1,1);
        LogSendUtil.sendActionLog(logActionPo);
        logActionPo.setG1(1L).setG2(2L).setS1("s1").setS2("s2");
        LogSendUtil.sendActionLog(logActionPo);
        logActionPo = new LogActionPo(uuid,channelId,uid, LogActionTypeEnum.region_after, 2,1);
        LogSendUtil.sendActionLog(logActionPo);
        logActionPo.setLevel(2).setReged(1);
        logActionPo.getLogBaseDevicePo().setClientVersion("1.1").setScreenWidth(100).setScreenHeight(500);
        LogSendUtil.sendActionLog(logActionPo);
    }

    @Test
    public void sendAppOnceLogTest(){
        LogAppOncePo logAppOncePo = new LogAppOncePo(uuid, channelId, 1);
        LogSendUtil.sendAppOnceLog(logAppOncePo);
        logAppOncePo.setLevel(1).getLogBaseDevicePo().setScreenHeight(500).setScreenWidth(100);
        LogSendUtil.sendAppOnceLog(logAppOncePo);
    }

    @Test
    public void sendCuLogTest(){
        LogCuPo logCuPo = new LogCuPo(channelId, 1, 1);
        LogSendUtil.sendCuLog(logCuPo);
    }

    @Test
    public void sendLevelLogTest(){
        LogLevelPo logLevelPo = new LogLevelPo(uid, channelId, 1, 3);
        LogSendUtil.sendLevelLog(logLevelPo);
        logLevelPo = new LogLevelPo(uid, channelId, 5, 20);
        LogSendUtil.sendLevelLog(logLevelPo);
    }

    @Test
    public void sendLoginLogTest(){
        LogLoginPo logLoginPo = new LogLoginPo(channelId, uid, LogLoginTypeEnum.login_in, new Date());
        LogSendUtil.sendLoginLog(logLoginPo);
        logLoginPo = new LogLoginPo(channelId, uid, LogLoginTypeEnum.login_out, new Date());
        logLoginPo.setOnline(100).setGuildId(1+"").setRoleName(LogUtil.stringFilterAll("nn|nn|nn"));
        LogSendUtil.sendLoginLog(logLoginPo);
    }

    @Test
    public void sendULoginLogTest(){
        LogLoginUPo logLoginUPo = new LogLoginUPo(uuid, channelId);
        LogSendUtil.sendULoginLog(logLoginUPo);
    }

    @Test
    public void sendMoneyLogTest(){
        LogMoneyPo logMoneyPo = new LogMoneyPo(channelId, uid, LogUtil.generateSequence(), reason, subreason,1,1,1,1 );
        LogSendUtil.sendMoneyLog(logMoneyPo);
        logMoneyPo = new LogMoneyPo(channelId, uid, LogUtil.generateSequence(), reason, subreason,1,1,1,1, "itemName", 1, "101");
        LogSendUtil.sendMoneyLog(logMoneyPo);
        logMoneyPo.setLevel(1).setPayed(1).setRegDt(new Date());
        LogSendUtil.sendMoneyLog(logMoneyPo);
    }

    @Test
    public void sendPayLogTest(){
        LogPayPo logPayPo = new LogPayPo(channelId, uid, LogPayTypeEnum.ingot, System.currentTimeMillis()+"", 1L,1L,1L,0,10, 0L);
        LogSendUtil.sendPayLog(logPayPo);
        logPayPo.setPayChannelId(1);
        LogSendUtil.sendPayLog(logPayPo);
        logPayPo.setPayId(1+"").setPayIdName("payIdName");
        LogSendUtil.sendPayLog(logPayPo);
    }

    @Test
    public void sendRegLogTest(){
        LogRegPo logRegPo = new LogRegPo(channelId, uid);
        LogSendUtil.sendRegLog(logRegPo);
    }

    @Test
    public void sendURegLogTest(){
        LogRegUPo logRegUPo = new LogRegUPo(uuid, channelId);
        LogSendUtil.sendURegLog(logRegUPo);
    }

    @Test
    public void sendAdVideoLogTest(){
        LogAdVideoPo logAdVideoPo = new LogAdVideoPo(channelId, uid, 1, LogAdVideoActionTypeEnum.ACTIVE_CLOSE);
        LogSendUtil.sendAdVideoLog(logAdVideoPo);
    }

    @Test
    public void sendBattleLogTest(){
        LogBattlePo logBattlePo = new LogBattlePo(channelId, uid, LogGamePatternLogTypeEnum.start, 1, 1);
        LogSendUtil.sendBattleLog(logBattlePo);
        logBattlePo = new LogBattlePo(channelId, uid, LogGamePatternLogTypeEnum.success_end, 1, 1, 100);
        LogSendUtil.sendBattleLog(logBattlePo);
        logBattlePo.setReason("1").setLevel(77).setRegDt(new Date());
        LogSendUtil.sendBattleLog(logBattlePo);
    }

    @Test
    public void sendCdkeyLogTest(){
        LogCdkeyPo logCdkeyPo = new LogCdkeyPo(channelId,uid,1,"abcde", "abc", "");
        LogSendUtil.sendCdkeyLog(logCdkeyPo);
        logCdkeyPo = new LogCdkeyPo(channelId,uid,1,"abcde", "", "重复使用");
        LogSendUtil.sendCdkeyLog(logCdkeyPo);
    }

    @Test
    public void sendEnergyLogTest(){
        LogEnergyPo logEnergyPo = new LogEnergyPo(channelId,uid,1,5);
        LogSendUtil.sendEnergyLog(logEnergyPo);
        logEnergyPo = new LogEnergyPo(channelId,uid,8,6);
        LogSendUtil.sendEnergyLog(logEnergyPo);
    }

    @Test
    public void sendEquipDegreeLogTest(){
        LogEquipDegreePo logEquipDegreePo = new LogEquipDegreePo(channelId,uid,1,101,10,16);
        LogSendUtil.sendEquipDegreeLog(logEquipDegreePo);
        logEquipDegreePo.setReged(1).setPayed(1);
        LogSendUtil.sendEquipDegreeLog(logEquipDegreePo);
    }

    @Test
    public void sendEquipLevelLogTest(){
        LogEquipLevelPo logEquipLevelPo = new LogEquipLevelPo(channelId,uid,1,101,7, 9);
        LogSendUtil.sendEquipLevelLog(logEquipLevelPo);
    }

    @Test
    public void sendEquipPlaywayLogTest(){
        LogEquipPlaywayPo logEquipPlaywayPo = new LogEquipPlaywayPo(channelId,uid,1,101,7,9,1);
        LogSendUtil.sendEquipPlaywayLog(logEquipPlaywayPo);
    }

    @Test
    public void sendEquipLogTest(){
        LogEquipPo logEquipPo = new LogEquipPo(channelId,uid, LogUtil.generateSequence(), "1", "1", AddOrReduceTypeEnum.Add, 1,101,5);
        LogSendUtil.sendEquipLog(logEquipPo);
    }

    @Test
    public void sendCustomLogTest(){
        LogCustomBasePo logCustomBasePo = new LogCustomBasePo("log_custom_test", channelId, uid);
        LogSendUtil.sendCustomLog(logCustomBasePo);
        LogSendUtil.sendCustomLog(logCustomBasePo,1);
        LogSendUtil.sendCustomLog(logCustomBasePo,1,2);
        LogSendUtil.sendCustomLog(logCustomBasePo,1,2,"a");
        LogSendUtil.sendCustomLog(logCustomBasePo,1,2,"a","b");
    }
}
