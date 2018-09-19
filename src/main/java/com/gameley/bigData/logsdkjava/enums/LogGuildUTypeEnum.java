package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 加入、退出公会
 *
 * @author C167
 *
 */
public enum LogGuildUTypeEnum {
	UNDEFINED(-1, BIConstants.UNDEFINE),
	join(1,"加入"),
	quit(2,"退出"),
	;

	public static LogGuildUTypeEnum parse(int val) {
		for (LogGuildUTypeEnum t : LogGuildUTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogGuildUTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private LogGuildUTypeEnum(int id, String name) {
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
