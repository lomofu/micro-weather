package com.lomofu.weathercollectionserver.service;

import com.lomofu.weathercollectionserver.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city-server")
public interface CityClient {
    @GetMapping("/cities")
    List<City> cityList()throws Exception;
}
