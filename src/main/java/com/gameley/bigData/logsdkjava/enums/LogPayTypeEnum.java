package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 充值类型
 *
 * @author C167
 *
 */
public enum LogPayTypeEnum {
	undefined(-1, BIConstants.UNDEFINE),
	ingot(1,"代币（钻石）"),
	month_card(2,"月卡"),
	;

	public static LogPayTypeEnum parse(int val) {
		for (LogPayTypeEnum t : LogPayTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogPayTypeEnum.undefined;
	}
	private int id;
	private String name;
	private LogPayTypeEnum(int id, String name) {
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
