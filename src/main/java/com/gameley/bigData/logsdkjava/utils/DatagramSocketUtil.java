package com.gameley.bigData.logsdkjava.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.DatagramSocket;
import java.net.SocketException;

@Slf4j
public class DatagramSocketUtil {

    private static class SingleDatagramSocket {
        private static final DatagramSocket CLIENT = createDatagramSocket();

        private static DatagramSocket createDatagramSocket() {
            try {
                return new DatagramSocket();
            } catch (SocketException e) {
                log.error("create DatagramSocket failed! {}",e);
                return null;
            }
        }
    }

    /**
     * 私有化构造器，防止外部调用
     */
    private DatagramSocketUtil() {}

    /**
     * 获取DatagramSocket的单例
     * @return DatagramSocket
     */
    public static DatagramSocket getInstance(){
        return SingleDatagramSocket.CLIENT;
    }
}
