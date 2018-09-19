package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 手机操作系统
 *
 * @author C167
 *
 */
public enum LogIngotAddTypeEnum {
	UNDEFINED(-1, BIConstants.UNDEFINE),
	pay(10001,"充值"),
	continuous_login(10002,"连登活动"),
	;

	public static LogIngotAddTypeEnum parse(int val) {
		for (LogIngotAddTypeEnum t : LogIngotAddTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogIngotAddTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private LogIngotAddTypeEnum(int id, String name) {
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
