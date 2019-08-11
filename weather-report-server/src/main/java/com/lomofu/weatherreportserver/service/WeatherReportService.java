package com.lomofu.weatherreportserver.service;

import com.lomofu.weatherreportserver.vo.Weather;

public interface WeatherReportService {
    Weather getDataByCityName(String cityName);
}
