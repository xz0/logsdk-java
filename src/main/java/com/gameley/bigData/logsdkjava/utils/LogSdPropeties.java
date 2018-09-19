package com.gameley.bigData.logsdkjava.utils;

import com.gameley.bigData.logsdkjava.enums.LogPlatIdTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author: 王志伟
 * @date: 2018/9/14 17:57
 * @desc:
 */
@Slf4j
public class LogSdPropeties {

    /**
     * 单例IpPort
     */
     private static LogSdPropeties instance ;

    private ResourceBundle resourceBundle;
    private Map<Integer,Integer> channelPlatMap;
    /**
     * 获取ip和port对象
     * @return IpPort
     */
    public static LogSdPropeties getInstance() {
        if(instance==null){
            instance = new LogSdPropeties();
        }
        return instance;
    }

    private LogSdPropeties(){
        channelPlatMap = new HashMap<>();
        resourceBundle = ResourceBundle.getBundle("log_sd");
        if(resourceBundle==null){
            log.error("请检查配置文件 classpath:/log_sd.properties 是否存在");
            return;
        }

        String channelPlat = resourceBundle.getString("channel_plat");
        if(StringUtil.isEmptyStr(channelPlat)){
            log.error("请检查配置文件 classpath:/log_sd.properties channel_plat是否进行了配置");
            return;
        }
        String[] channelPlatArr = channelPlat.split(",");
        if(channelPlatArr==null || channelPlatArr.length<=0){
            log.error("请检查配置文件 classpath:/log_sd.properties channel_plat是否进行了配置");
            return;
        }
        for (int i = 0; i < channelPlatArr.length; i++) {
            String[] tmpChannelPlatArr = channelPlatArr[i].split("-");
            if(tmpChannelPlatArr==null || tmpChannelPlatArr.length!=2){
                log.error("请检查配置文件 classpath:/log_sd.properties channel_plat 格式是否正确 channelId-platId,channelId-platId,channelId-platId");
                return;
            }
            try {
                Integer channelId= Integer.parseInt(tmpChannelPlatArr[0]);
                Integer platId = Integer.parseInt(tmpChannelPlatArr[1]);
                channelPlatMap.put(channelId, platId);
            }catch (Exception e){
                log.error("请检查配置文件 classpath:/log_sd.properties channel_plat 格式是否正确 channelId-platId,channelId-platId,channelId-platId");
                return;
            }
        }
    }

    public String getIp(){
        String ip = resourceBundle.getString("ip");
        if(StringUtil.isEmptyStr(ip)){
            log.error("请检查配置文件 classpath:/log_sd.properties ip 是否进行配置");
            return null;
        }
        return ip;
    }

    public int getPort(){
        try {
            int port = Integer.parseInt(resourceBundle.getString("port"));
            return port;
        }catch (Exception e){
            log.error("请检查配置文件 classpath:/log_sd.properties port 是否进行配置");
            return 0;
        }
    }

    public int getGameId(){
        try {
            int gameId = Integer.parseInt(resourceBundle.getString("gameId"));
            return gameId;
        }catch (Exception e){
            log.error("请检查配置文件 classpath:/log_sd.properties gameId 是否进行配置");
            return 0;
        }
    }

    public int getRegionId(){
        try {
            int regionId = Integer.parseInt(resourceBundle.getString("regionId"));
            return regionId;
        }catch (Exception e){
            log.error("请检查配置文件 classpath:/log_sd.properties regionId 是否进行配置");
            return 0;
        }
    }

    public int getPlatId(int channelId){
        if(channelPlatMap==null){
            log.error("请检查配置文件 classpath:/log_sd.properties channel_plat 是否进行配置");
            return LogPlatIdTypeEnum.ANDROID.getId();
        }
        Integer platId = channelPlatMap.get(channelId);
        if(platId==null){
            log.error("请检查配置文件 classpath:/log_sd.properties channel_plat 是否配置了channelId:{} 的对应关系",channelId);
            return LogPlatIdTypeEnum.ANDROID.getId();
        }
        return platId;
    }


}
