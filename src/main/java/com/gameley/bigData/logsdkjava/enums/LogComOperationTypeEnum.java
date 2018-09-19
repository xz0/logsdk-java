package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 运营商 网络类型
 *
 * @author C167
 *
 */
public enum LogComOperationTypeEnum {
	UNDEFINED(-1, BIConstants.UNDEFINE),
	yi_dong(1,"移动"),
	lian_tong(2, "联通"),
	dian_xin(3, "电信"),
	wifi(4, "wifi"),
	;

	public static LogComOperationTypeEnum parse(int val) {
		for (LogComOperationTypeEnum t : LogComOperationTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogComOperationTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private LogComOperationTypeEnum(int id, String name) {
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
