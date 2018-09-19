package com.gameley.bigData.logsdkjava.enums;



import com.gameley.bigData.logsdkjava.constants.BIConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * 广告视频相关具体动作
 *
 * @author C167
 *≤
 */
public enum LogAdVideoActionTypeEnum {
	UNDEFINED(-1, BIConstants.UNDEFINE),
	ACTIVE_OPEN(0, "主动触发打开视频窗口"),
	ACTIVE_CLOSE(1, "看到视频窗口后主动关闭"),
	CLICK_VIDEO(2, "点击视频播放视频"),
	MIDWAY_CLOSE(3, "视频中途关闭"),
	WATCH_END(4, "观看结束"),
	OBTAIN_REWARD(5, "获得奖励"),
	NO_AD(6, "没有可观看的广告"),
	;

	public static LogAdVideoActionTypeEnum parse(int val) {
		for (LogAdVideoActionTypeEnum t : LogAdVideoActionTypeEnum.values()) {
			if (val == t.getId()){
				return t;
			}
		}
		return LogAdVideoActionTypeEnum.UNDEFINED;
	}
	private int id;
	private String name;
	private LogAdVideoActionTypeEnum(int id, String name) {
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
	public static List<Integer> getAllIds() {
		List<Integer> list = new ArrayList<>();
		for (LogAdVideoActionTypeEnum t : LogAdVideoActionTypeEnum.values()) {
			if (t.getId() != -1) {
				list.add(t.getId());
			}
		}
		return list;
	}
}
