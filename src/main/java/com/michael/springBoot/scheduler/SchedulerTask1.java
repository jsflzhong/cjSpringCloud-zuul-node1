package com.michael.springBoot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务测试类
 * 2018/3/27
 *
 * @author cj
 */
@Component
public class SchedulerTask1 {

    private int count = 0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 每六秒执行一次
     */
    //@Scheduled(cron = "*/6 * * * * ?")
    private void testSchedulerTask1() {
        System.out.println("testSchedulerTask1 is runing : " + (count++));
    }

    /**
     * 每六秒执行一次
     */
    //@Scheduled(fixedRate = 6000)
    public void testSchedulerTask2() {
        System.out.println("now is ：" + dateFormat.format(new Date()));
    }
}
