package com.gameley.bigData.logsdkjava.utils;

import com.gameley.bigData.logsdkjava.enums.AddOrReduceTypeEnum;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 提供一些日志处理的一些常用方法
 * @author zhaoyang
 */
public class LogUtil {
    private LogUtil(){}
    /**
     * 分隔线
     */
    private static final String VERTICAL_LINE = "|";

    /**
     * 过滤特殊字符正则表达式
     */
    private static final String NICK_CHARS_REGEXP="[\\ -\\u009f\\u200e\\u200f\\u202a-\\u202e\\ufff9-\\ufffb\\u0300-\\u036f\\u0590-\\u05ff\\u0600-\\u06ff\\u0780-\\u07bf\\u0900-\\u097f\\u0a80-\\u0aff\\u0c80-\\u0cff\\u0e00-\\u0e7f\\u1200-\\u137f\\u200a-\\u200f\\ud800-\\uf8ff\\ufb00-\\ufdff]";

    /**
     * 通过比较新老数量，返回相对应的枚举
     * @param oldNum 老的数量--int类型
     * @param newNum 新的数量--int类型
     * @return AddOrReduceTypeEnum
     */
    public static AddOrReduceTypeEnum getAddOrReduceTypeEnum(int oldNum, int newNum){
       return getAddOrReduceTypeEnum((long)oldNum, (long)newNum);
    }

    /**
     * 通过比较新老数量，返回相对应的枚举
     * @param oldNum 老的数量--long类型
     * @param newNum 新的数量--long类型
     * @return AddOrReduceTypeEnum
     */
    public static AddOrReduceTypeEnum getAddOrReduceTypeEnum(long oldNum, long newNum){
        if(oldNum<newNum){
            return AddOrReduceTypeEnum.Add;
        }else if(oldNum>newNum){
            return AddOrReduceTypeEnum.Reduce;
        }else {
            return AddOrReduceTypeEnum.NULL;
        }
    }
    /**
     * 将传进来的对象数组生成以'|'分隔的字符串,不过滤传进来的数据
     * @param objects 对象数组
     * @return 字符串
     */
    public static String toLogFormatNoFilter(Object... objects) {
        StringBuffer sb = new StringBuffer();
        for (Object object : objects) {
            sb.append(object).append(VERTICAL_LINE);
        }
        if (sb.length() > 0) {
            return  sb.substring(0, sb.length()-1);
        }
        return "";
    }

    /**
     * 将传进来的对象数组生成以'|'分隔的字符串
     * @param objects 对象数组
     * @return 字符串
     */
    public static String toLogFormat (Object... objects) {
        return toLogFormatWithSb(null, objects);
    }

    /**
     * 将传进来的对象数组生成以'|'分隔的字符串,frontStr不会进行过滤，只会对后面的字符串进行过滤
     * @param tableName 表名
     * @param frontStr 前一部分字符串
     * @param objects  后面要拼接在一起的字段
     * @return
     */
    public static String toLogFormatWithFrontStr (String tableName,String frontStr, Object... objects) {
        StringBuffer sb = new StringBuffer();
        sb.append(tableName).append(VERTICAL_LINE).append(frontStr).append(VERTICAL_LINE);
        return toLogFormatWithSb(sb, objects);
    }

    /**
     * 将传进来的对象数组生成以'|'分隔的字符串,frontStr不会进行过滤，只会对后面的字符串进行过滤
     * @param frontStr 前一部分字符串
     * @param objects  后面要拼接在一起的字段
     * @return
     */
    public static String toLogFormatWithFrontStr (String frontStr, Object... objects) {
        StringBuffer sb = new StringBuffer();
        sb.append(frontStr).append(VERTICAL_LINE);
        return toLogFormatWithSb(sb, objects);
    }


    /**
     * 重载方法：将传进来的对象数组生成以'|'分隔的字符串
     * @param sb StringBuilder对象
     * @param objects 要拼接的对象
     * @return
     */
    public static String toLogFormatWithSb (StringBuffer sb, Object... objects) {
        if (sb == null) {
            sb = new StringBuffer();
        }
        String field;
        for(Object o : objects) {
            field = o == null ? "NULL" : stringFilter(o.toString());
            sb.append(field).append(VERTICAL_LINE);
        }
        if (sb.length() > 0) {
            return  sb.substring(0, sb.length()-1);
        }
        return "";
    }


    /**
     * 去掉字符串里的特殊字符'|'
     * @param str 字符串
     * @return 字符串
     */
    public static String stringFilter(String str) {
        if(StringUtil.isEmpty(str)){
            return "";
        }
        return str.replace(VERTICAL_LINE, "");
    }

    /**
     * 去掉字符串里的特殊字符'|'、换行符、制表符及其它不可见特殊字符，以免影响日志的解析
     * @param str 字符串
     * @return 字符串
     */
    public static String stringFilterAll(String str) {
        if(StringUtil.isEmpty(str)){
            return "";
        }
        Pattern p = Pattern.compile(NICK_CHARS_REGEXP);
        return p.matcher(str).replaceAll("")
                .replace(VERTICAL_LINE,"")
                .replace("\\\\n","")
                .replace("\\\\t","");
    }

    /**
     * 生成当前唯一的序列号，用于一次动作多个日志关联
     * @return 序列号
     */
    public static String generateSequence() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }
}
