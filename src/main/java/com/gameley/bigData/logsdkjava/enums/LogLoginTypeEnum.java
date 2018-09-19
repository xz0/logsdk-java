package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 登录类型
 *
 * @author C167
 *
 */
public enum LogLoginTypeEnum {
	undefined(-1, BIConstants.UNDEFINE),
	login_out(0,"登出"),
	login_in(1,"登入"),
	;

	public static LogLoginTypeEnum parse(int val) {
		for (LogLoginTypeEnum t : LogLoginTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogLoginTypeEnum.undefined;
	}
	private int id;
	private String name;
	private LogLoginTypeEnum(int id, String name) {
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
