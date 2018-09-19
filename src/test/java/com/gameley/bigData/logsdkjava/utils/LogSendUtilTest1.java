package com.gameley.bigData.logsdkjava.utils;

import com.gameley.bigData.logsdkjava.enums.*;
import com.gameley.bigData.logsdkjava.po.*;
import org.junit.Test;

import java.util.Date;

public class LogSendUtilTest1 {
    int channelId = 2006603;
    String uid = "kijhdi89234j";
    String uuid = "lolnb12321";

    @Test
    public void testTask() {
        LogTaskPo logTaskPo = new LogTaskPo(channelId, uid, 1, 1010);
        logTaskPo.setRegDt(new Date()).setLevel(10).setPayed(1).setReason("AA").setReged(1).setSequenceId("ewrewr").setVip(10).setSubReason("BB");
        LogSendUtil.sendTaskLog(logTaskPo);
    }

    @Test
    public void testShareOut() {
        LogShareOutPo logShareOutPo = new LogShareOutPo(channelId, uid,2);
        logShareOutPo.setRegDt(new Date()).setLevel(11).setPayed(1).setVip(1).setReged(1);
        LogSendUtil.sendShareOutLog(logShareOutPo);
    }

    @Test
    public void testShareIn() {
        LogShareInPo logShareInPo = new LogShareInPo(channelId, uid, 4, 1);
        logShareInPo.setRegDt(new Date()).setLevel(12).setPayed(1).setReged(0).setVip(10);
        LogSendUtil.sendShareInLog(logShareInPo);
    }

    @Test
    public void testRegU() {
        LogRegUPo logRegUPo = new LogRegUPo(uuid, channelId);
        logRegUPo.getLogBaseDevicePo().setIp("192.168.2.68");
        LogSendUtil.sendURegLog(logRegUPo);
    }

    @Test
    public void testReg() {
        LogRegPo logRegPo = new LogRegPo(channelId, uid);
        logRegPo.setRegDt(new Date());
        LogSendUtil.sendRegLog(logRegPo);
        logRegPo.setLevel(11).setPayed(1).setRegDt(new Date()).setVip(10);
        LogSendUtil.sendRegLog(logRegPo);
    }

    @Test
    public void testPower() {
        LogPowerPo logPowerPo = new LogPowerPo(channelId, uid,10L, 100L);
        logPowerPo.setRegDt(new Date());
        LogSendUtil.sendPowerLog(logPowerPo);
    }

    @Test
    public void testPay() {
        LogPayPo logPayPo = new LogPayPo(channelId, uid, LogPayTypeEnum.month_card, "24324", 10,
        20, 300,1, 3, 90);
        logPayPo.setRegDt(new Date());
        LogSendUtil.sendPayLog(logPayPo);
    }

    @Test
    public void testNewTask() {
        LogNewTaskPo logNewTaskPo = new LogNewTaskPo(channelId,uid,1,1003);
        logNewTaskPo.setRegDt(new Date());
        LogSendUtil.sendNewTaskLog(logNewTaskPo);
    }

    @Test
    public void testMoney() {
        LogMoneyPo logMoneyPo = new LogMoneyPo(channelId,uid, "ewrwerew", "一级原因", "二级原因", 100, 300,1, 1);
        logMoneyPo.setRegDt(new Date());
        LogSendUtil.sendMoneyLog(logMoneyPo);
    }

    @Test
    public void tesLoginU() {
        LogLoginUPo logLoginUPo = new LogLoginUPo(uuid, channelId);
        LogSendUtil.sendULoginLog(logLoginUPo);
    }

    @Test
    public void testLogin() {
        LogLoginPo logLoginPo = new LogLoginPo(channelId, uid, LogLoginTypeEnum.login_in, 200, "sdfsdf", "xhh");
        logLoginPo.setRegDt(new Date());
        LogSendUtil.sendLoginLog(logLoginPo);
    }

    @Test
    public void testLevel() {
        LogLevelPo logLevelPo = new LogLevelPo(uid,channelId, 10, 20);
        logLevelPo.setRegDt(new Date());
        LogSendUtil.sendLevelLog(logLevelPo);
    }

    @Test
    public void testItem() {
        LogItemPo logItemPo = new LogItemPo(channelId, uid, "werewewr", "一级原因", "二级原因",
         333, 23432, 10, 13);
        LogSendUtil.sendItemLog(logItemPo);
    }

    @Test
    public void testGuildU() {
        LogGuildUPo logGuildUPo = new LogGuildUPo(channelId, uid, LogGuildUTypeEnum.join, "asd");
        LogSendUtil.sendGuildULog(logGuildUPo);
    }

    @Test
    public void testGuildLevel() {
        LogGuildLevelPo logGuildLevelPo = new LogGuildLevelPo("1", 10, 20);
        LogSendUtil.sendGuildLevelLog(logGuildLevelPo);
    }

    @Test
    public void testGuild() {
        LogGuildPo logGuildPo = new LogGuildPo(channelId, uid, LogGuildTypeEnum.create, "4");
        LogSendUtil.sendGuildLog(logGuildPo);
    }

    @Test
    public void testGuildDonate() {
        LogGuildDonatePo logGuildDonatePo = new LogGuildDonatePo(channelId, uid, "11");
        LogSendUtil.sendGuildDonateLog(logGuildDonatePo);
    }

    @Test
    public void testGamePattern() {
        LogGamePatternPo logGamePatternPo = new LogGamePatternPo(channelId, uid, LogGamePatternLogTypeEnum.start, 20, 30, 40, 50);
        LogSendUtil.sendGamePatternLog(logGamePatternPo);
    }

    @Test
    public void testFriends() {
        LogFriendsPo logFriendsPo = new LogFriendsPo(channelId, uid, 10, 20, 1);
        LogSendUtil.sendFriendsLog(logFriendsPo);
    }

    @Test
    public void testEquip() {
        LogEquipPo logEquipPo = new LogEquipPo(channelId, uid, "dsfdsfd", "一级原因", "二级原因",
                AddOrReduceTypeEnum.Add, 1, 10, 1);
        LogSendUtil.sendEquipLog(logEquipPo);
    }

    @Test
    public void testEquipPlayway() {
        LogEquipPlaywayPo logEquipPlaywayPo = new LogEquipPlaywayPo(channelId, uid, 1, 2, 10, 20, 4);
        LogSendUtil.sendEquipPlaywayLog(logEquipPlaywayPo);
    }

    @Test
    public void testEquipLevel() {
        LogEquipLevelPo logEquipLevelPo = new LogEquipLevelPo(channelId, uid, 1 ,11, 10, 23);
        LogSendUtil.sendEquipLevelLog(logEquipLevelPo);
    }

    @Test
    public void testEquipDegree() {
        LogEquipDegreePo logEquipDegreePo = new LogEquipDegreePo(channelId, uid, 1,1, 10, 11);
        LogSendUtil.sendEquipDegreeLog(logEquipDegreePo);
    }

    @Test
    public void testEnergy() {
        LogEnergyPo logEnergyPo = new LogEnergyPo(channelId, uid, 10, 80);
        LogSendUtil.sendEnergyLog(logEnergyPo);
    }

    @Test
    public void testCdk(){
        LogCdkeyPo logCdkeyPo = new LogCdkeyPo(channelId, uid, 23, "erewrew", "234", "rrr");
        LogSendUtil.sendCdkeyLog(logCdkeyPo);
    }

}
