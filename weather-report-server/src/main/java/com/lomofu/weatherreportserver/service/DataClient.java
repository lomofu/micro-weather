package com.lomofu.weatherreportserver.service;

import com.lomofu.weatherreportserver.service.Impl.DataClientFallback;
import com.lomofu.weatherreportserver.vo.City;
import com.lomofu.weatherreportserver.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "weather-eureka-client",fallback = DataClientFallback.class)
public interface DataClient {
    /**
     * 获取城市列表
     */
    @GetMapping("/city/cities")
    List<City> cityList();

    /**
     * 根据城市名字查询天气
     */
    @GetMapping("/data/weather/cityName/{cityName}")
    WeatherResponse getDataByCityName(@PathVariable("cityName")String cityName);
}
