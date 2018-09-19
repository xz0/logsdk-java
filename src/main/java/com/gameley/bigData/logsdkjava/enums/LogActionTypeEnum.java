package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 行为日志类型
 *
 * @author C167
 *
 */
public enum LogActionTypeEnum {
	undefined(-1, BIConstants.UNDEFINE),
	region_before(1,"进区服前行为"),
	region_after(2,"进区服后行为"),
	;

	public static LogActionTypeEnum parse(int val) {
		for (LogActionTypeEnum t : LogActionTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogActionTypeEnum.undefined;
	}
	private int id;
	private String name;
	private LogActionTypeEnum(int id, String name) {
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
