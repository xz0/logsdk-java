package com.gameley.bigData.logsdkjava.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhaoyang
 */
@Slf4j
class UDPUtilJava {
    private UDPUtilJava(){}

    /**
     * 发送日志数据
     * @param data
     */
    public static void sendLogData(String data) {
        String targetIP = LogSdPropeties.getInstance().getIp();
        Integer targetPort = LogSdPropeties.getInstance().getPort();
        if(StringUtil.isEmptyStr(targetIP) || targetPort==null || targetPort<=0){
            log.error("请检查配置文件 classpath:/log_sd.properties ip port 是否进行了配置");
            return;
        }

        byte[] dataByte;
        try {
            dataByte = data.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("log send: unsupported encoding format！{}",e);
            return;
        }

        /*获取客户端实例*/
        DatagramSocket client = DatagramSocketUtil.getInstance();
        if(client == null){
            return;
        }

        /*创建InetAddress对象*/
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getByName(targetIP);
        } catch (UnknownHostException e) {
            log.error("log send: ip is wrong! ip: {}. {}", targetIP,e);
            return;
        }

        /*创建数据包*/
        DatagramPacket dp = new DatagramPacket(dataByte, dataByte.length, inetAddress, targetPort);

        /*使用客户端发送数据包*/
        try {
            client.send(dp);
        } catch (IOException e) {
            log.error("log send failed! {}",e);
        }
    }
}
