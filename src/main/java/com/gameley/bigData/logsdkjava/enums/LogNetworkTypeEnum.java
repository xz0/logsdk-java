package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 运营商 网络类型
 *
 * @author C167
 *
 */
public enum LogNetworkTypeEnum {
	UNDEFINED(-1, BIConstants.UNDEFINE),
	wifi(1,"wifi"),
	N4G(2, "4G"),
	N3G(3, "3G"),
	N2G(4, "2G"),
	;

	public static LogNetworkTypeEnum parse(int val) {
		for (LogNetworkTypeEnum t : LogNetworkTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogNetworkTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private LogNetworkTypeEnum(int id, String name) {
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
