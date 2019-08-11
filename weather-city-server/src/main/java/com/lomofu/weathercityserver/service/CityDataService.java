package com.lomofu.weathercityserver.service;

import com.lomofu.weathercityserver.vo.City;

import java.util.List;

public interface CityDataService {
    List<City> getCityList() throws Exception;
}
