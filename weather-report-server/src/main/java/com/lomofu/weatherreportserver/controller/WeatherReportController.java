package com.lomofu.weatherreportserver.controller;

import com.lomofu.weatherreportserver.service.WeatherReportService;
import com.lomofu.weatherreportserver.vo.Weather;
import com.lomofu.weatherreportserver.vo.WeatherResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherReportController {
    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/get/{cityName}")
//    @HystrixCommand(fallbackMethod = )
    public WeatherResponse getWeatherReportByCityName(@PathVariable("cityName")String cityName){
        Weather weather = weatherReportService.getDataByCityName(cityName);
        WeatherResponse weatherResponse = new WeatherResponse();
        BeanUtils.copyProperties(weather,weatherResponse);
        return weatherResponse;
    }
}
