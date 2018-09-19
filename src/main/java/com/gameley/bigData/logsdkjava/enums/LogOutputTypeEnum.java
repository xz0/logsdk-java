package com.gameley.bigData.logsdkjava.enums;

import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 对应次公共统计 各种产出资源统计
 * 每一个类型对应一个日志表
 *
 *
 * @author C167
 *
 */
public enum LogOutputTypeEnum{
	UNDEFINED(-1, BIConstants.UNDEFINE, "", 0),
	money(1,"游戏币", "log_money", 1),
    equip(2, "装备", "log_equip", 2),
	item(3, "道具", "log_item", 3),
	energy(4, "体力", "log_energy", 0),
	;

	public static LogOutputTypeEnum parse(int val) {
		for (LogOutputTypeEnum t : LogOutputTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogOutputTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private String tableName;
	private int sdType;
	private LogOutputTypeEnum(int id, String name, String tableName, int sdType) {
		this.id = id;
		this.name = name;
		this.tableName = tableName;
		this.sdType = sdType;
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
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getSdType() {
		return sdType;
	}
	public void setSdType(int sdType) {
		this.sdType = sdType;
	}
}
