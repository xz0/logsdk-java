package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 开始、结束（完成）
 *
 * @author C167
 *
 */
public enum LogStartEndTypeEnum {
	UNDEFINED(-1, BIConstants.UNDEFINE),
	start(1,"开始"),
	end(2,"结束（完成）"),
	;

	public static LogStartEndTypeEnum parse(int val) {
		for (LogStartEndTypeEnum t : LogStartEndTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogStartEndTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private LogStartEndTypeEnum(int id, String name) {
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
