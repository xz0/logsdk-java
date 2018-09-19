package com.gameley.bigData.logsdkjava.enums;

public enum AddOrReduceTypeEnum implements ITranslateEnum {
	UNDEFINED(-1,"未定义"),
	Reduce(0,"减"),
	Add(1,"加"),
	NULL(2,"不变");

	private int value;
	private String name;
	
	private AddOrReduceTypeEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static AddOrReduceTypeEnum parse(int val) {
		for (AddOrReduceTypeEnum t : AddOrReduceTypeEnum.values()) {
			if (val == t.getValue())
				return t;
		}
		return AddOrReduceTypeEnum.UNDEFINED;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDesc() {
		return this.getName();
	}
}
