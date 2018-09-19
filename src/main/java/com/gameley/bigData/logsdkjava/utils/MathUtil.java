package com.gameley.bigData.logsdkjava.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author zhaoyang
 */
@Slf4j
public class MathUtil {
    private MathUtil(){}
    private static Random random = new Random(System.currentTimeMillis());

    /**
     * 随机类型
     */
    public enum RandomType{
        /** 前闭后开[)*/
        K,
        /** 前闭后闭[]*/
        B
    }

    /**
     * 随机数计算 [0,i)
     * @param i
     * @return
     */
    public static int random(int i){
        return random(0, i);
    }

    /**
     * 随机数计算 [start,end)
     * @param start
     * @param end
     * @return
     */
    public static int random(int start,int end){
        return random(start, end, RandomType.K);
    }

    /**
     * 随机数计算 [start,end ) or ]
     * @param start
     * @param end
     * @param randomType
     * @return
     */
    public static int random(int start,int end,RandomType randomType){
        if(end-start<0){
            int smaller = end;
            end = start;
            start = smaller;
        }else if(end-start==0){
            return start;
        }
        if(randomType== RandomType.B){
            end++;
        }
        return start+random.nextInt(end-start);
    }
}
