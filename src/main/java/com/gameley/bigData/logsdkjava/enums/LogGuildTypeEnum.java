package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 公会创建、解散
 *
 * @author C167
 *
 */
public enum LogGuildTypeEnum {
	UNDEFINED(-1, BIConstants.UNDEFINE),
	create(1,"创建"),
	dissolve(2,"解散"),
	;

	public static LogGuildTypeEnum parse(int val) {
		for (LogGuildTypeEnum t : LogGuildTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogGuildTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private LogGuildTypeEnum(int id, String name) {
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
