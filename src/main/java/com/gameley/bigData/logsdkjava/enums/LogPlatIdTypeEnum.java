package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 平台类型
 *
 * @author C167
 *
 */
public enum LogPlatIdTypeEnum {
	UNDEFINED(-1, BIConstants.UNDEFINE),
	IOS(1,"苹果正版"),
	IOS_YUEYU(2,"苹果越狱"),
	ANDROID(3, "安卓"),
	;

	public static LogPlatIdTypeEnum parse(int val) {
		for (LogPlatIdTypeEnum t : LogPlatIdTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogPlatIdTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private LogPlatIdTypeEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
