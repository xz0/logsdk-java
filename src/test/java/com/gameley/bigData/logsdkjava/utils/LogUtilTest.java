package com.gameley.bigData.logsdkjava.utils;

import com.gameley.bigData.logsdkjava.po.LogActionPo;
import com.gameley.bigData.logsdkjava.po.LogCuPo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: 王志伟
 * @date: 2018/9/12 9:57
 * @desc:
 */
@Slf4j
public class LogUtilTest {

    @Test
    public void toLogFormatTest(){
//        new LogActionPo();
//        log.info(LogUtil.toLogFormat(null,"","a","b","c","","d"));
    }

    @Test
    public void generateSequenceTest(){
        log.info(LogUtil.generateSequence());
        log.info(LogUtil.generateSequence());
        log.info(LogUtil.generateSequence());
    }
}
