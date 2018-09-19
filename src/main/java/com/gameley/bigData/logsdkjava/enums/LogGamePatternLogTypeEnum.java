package com.gameley.bigData.logsdkjava.enums;


import com.gameley.bigData.logsdkjava.constants.BIConstants;

/**
 * 游戏模式日志类型
 *
 * @author C167
 *
 */
public enum LogGamePatternLogTypeEnum {
	UNDEFINED(-1, BIConstants.UNDEFINE),
	start(1,"开始"),
	success_end(2,"成功结束"),
	fail_end(3,"失败结束"),
	;

	public static LogGamePatternLogTypeEnum parse(int val) {
		for (LogGamePatternLogTypeEnum t : LogGamePatternLogTypeEnum.values()) {
			if (val == t.getId())
				return t;
		}
		return LogGamePatternLogTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private LogGamePatternLogTypeEnum(int id, String name) {
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
