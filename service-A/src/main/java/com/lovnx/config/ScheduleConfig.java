package com.lovnx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ScheduleConfig {
    @Autowired
    SpringAsyncConfig springAsyncConfig;

//    @Scheduled(cron = "* 1/5 * * * ?")
//    public void dayJob() throws InterruptedException {
//        springAsyncConfig.asyncMethodWithConfiguredExecutor();
//    }
//    @Scheduled(cron = "* 1/5 * * * ?")
//    public void dayJob1() throws InterruptedException {
//        springAsyncConfig.asyncMethodWithConfiguredExecutor();
//    }
}
