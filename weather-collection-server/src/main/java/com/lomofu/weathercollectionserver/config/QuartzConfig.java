package com.lomofu.weathercollectionserver.config;

import com.lomofu.weathercollectionserver.job.Sync;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时任务
 */
@Configuration
public class QuartzConfig {
    private final int SYNCTIME  = 1800;

    @Bean
    public JobDetail weatherDataSyncJobDeatil(){
        return JobBuilder.newJob(Sync.class).withIdentity("weatherSyncJob").storeDurably().build();
    }

    @Bean
    public Trigger weatherDataSyncTrigger(){
        //执行定时任务
        SimpleScheduleBuilder simpleScheduleBuilder= SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(SYNCTIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDeatil()).withIdentity("weatherDataSyncTrigger").withSchedule(simpleScheduleBuilder).build();
    }
}
