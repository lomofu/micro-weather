package com.lomofu.weathercityserver.controller;

import com.lomofu.weathercityserver.service.CityDataService;
import com.lomofu.weathercityserver.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityDataController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> cityList()throws Exception{
        return cityDataService.getCityList();
    }
}
