package com.gameley.bigData.logsdkjava.po.base;

import com.gameley.bigData.logsdkjava.enums.LogComOperationTypeEnum;
import com.gameley.bigData.logsdkjava.enums.LogNetworkTypeEnum;
import com.gameley.bigData.logsdkjava.utils.LogUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: 王志伟
 * @date: 2018/9/11 18:33
 * @desc:
 */
@Slf4j
@Getter
public class LogBaseDevicePo implements ILogPo{
    /**
     * 设备唯一id
     */
    private String deviceId;
    private String ip;
    /**
     * 客户端版本号
     */
    private String clientVersion;
    /**
     * 终端操作系统版本
     */
    private String systemSoftware;
    /**
     * 移动终端机型
     */
    private String systemHardware;
    /**
     * 运营商
     */
    private LogComOperationTypeEnum comOperationTypeEnum = LogComOperationTypeEnum.yi_dong;
    /**
     * 网络
     */
    private LogNetworkTypeEnum networkTypeEnum = LogNetworkTypeEnum.N4G;
    /**
     * cpu类型-频率-核数
     */
    private String cpuHardware;
    /**
     * gpu类型-频率-核数
     */
    private String gpuHardware;
    /**
     * 内存
     */
    private int memory;
    /**
     * 显示屏宽度
     */
    private int screenWidth;
    /**
     * 显示屏高度
     */
    private int screenHeight;
    /**
     * 像素密度
     */
    private float density;
    /**
     * Opengl render信息
     */
    private String glRender;
    /**
     * Opengl版本信息
     */
    private String glVersion;
    /**
     * 手机号
     */
    private String phoneNumber;

    public LogBaseDevicePo() {
    }

    public LogBaseDevicePo setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public LogBaseDevicePo setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public LogBaseDevicePo setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
        return this;
    }

    public LogBaseDevicePo setSystemSoftware(String systemSoftware) {
        this.systemSoftware = systemSoftware;
        return this;
    }

    public LogBaseDevicePo setSystemHardware(String systemHardware) {
        this.systemHardware = systemHardware;
        return this;
    }

    public LogBaseDevicePo setComOperationTypeEnum(LogComOperationTypeEnum comOperationTypeEnum) {
        this.comOperationTypeEnum = comOperationTypeEnum;
        return this;
    }

    public LogBaseDevicePo setNetworkTypeEnum(LogNetworkTypeEnum networkTypeEnum) {
        this.networkTypeEnum = networkTypeEnum;
        return this;
    }

    public LogBaseDevicePo setCpuHardware(String cpuHardware) {
        this.cpuHardware = cpuHardware;
        return this;
    }

    public LogBaseDevicePo setGpuHardware(String gpuHardware) {
        this.gpuHardware = gpuHardware;
        return this;
    }

    public LogBaseDevicePo setMemory(int memory) {
        this.memory = memory;
        return this;
    }

    public LogBaseDevicePo setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
        return this;
    }

    public LogBaseDevicePo setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
        return this;
    }

    public LogBaseDevicePo setDensity(float density) {
        this.density = density;
        return this;
    }

    public LogBaseDevicePo setGlRender(String glRender) {
        this.glRender = glRender;
        return this;
    }

    public LogBaseDevicePo setGlVersion(String glVersion) {
        this.glVersion = glVersion;
        return this;
    }

    public LogBaseDevicePo setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public String getLogStr(){
        return LogUtil.toLogFormat(this.deviceId,this.ip,this.clientVersion,this.systemSoftware,this.systemHardware,this.comOperationTypeEnum.getId(),this.networkTypeEnum.getId(),this.cpuHardware,
                this.gpuHardware, this.memory,this.screenWidth,this.screenHeight,this.density,this.glRender, this.glVersion,this.phoneNumber);
    }
}
