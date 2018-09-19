package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 手机操作系统
 *
 * @author C167
 *
 */
public enum LogIngotConsumeTypeEnum {
	UNDEFINED(-1, BIConstants.UNDEFINE),
	store(1,"商城购买"),
	;

	public static LogIngotConsumeTypeEnum parse(int val) {
		for (LogIngotConsumeTypeEnum t : LogIngotConsumeTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogIngotConsumeTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private LogIngotConsumeTypeEnum(int id, String name) {
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
