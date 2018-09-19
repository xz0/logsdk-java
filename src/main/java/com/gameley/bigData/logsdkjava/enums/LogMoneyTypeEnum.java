package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 钱的类型
 *
 * @author C167
 *
 */
public enum LogMoneyTypeEnum {
	undefined(-1, BIConstants.UNDEFINE),
	ingot(1,"代币（钻石）"),
	gold(2,"游戏币（金币）"),
	;

	public static LogMoneyTypeEnum parse(int val) {
		for (LogMoneyTypeEnum t : LogMoneyTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogMoneyTypeEnum.undefined;
	}
	private int id;
	private String name;
	private LogMoneyTypeEnum(int id, String name) {
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
