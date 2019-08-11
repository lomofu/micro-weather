package com.lomofu.weathercollectionserver.job;

import com.lomofu.weathercollectionserver.service.CityClient;
import com.lomofu.weathercollectionserver.service.WeatherDataCollectionService;
import com.lomofu.weathercollectionserver.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 同步数据
 */
@Slf4j
public class Sync extends QuartzJobBean {

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    @Autowired
    private CityClient cityClient;



    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("开启天气同步服务" + new Date());
        List<City> cityList = null;

        try {
            //TODO 改为由城市数据API微服务提供数据
            cityList = cityClient.cityList();

        } catch (Exception e) {
            log.error("error Exception" + e.getMessage());
        }

        //城市名字获取天气
        cityList
                .stream()
                .forEach(e -> weatherDataCollectionService.sysncDataByCityName(e.getCityname()));
        log.info("天气同步结束" + new Date());
    }
}
