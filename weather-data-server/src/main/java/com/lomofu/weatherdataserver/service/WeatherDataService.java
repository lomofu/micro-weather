package com.lomofu.weatherdataserver.service;

import com.lomofu.weatherdataserver.vo.WeatherResponse;

public interface WeatherDataService {
    /**
     * 根据城市名字查询数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
