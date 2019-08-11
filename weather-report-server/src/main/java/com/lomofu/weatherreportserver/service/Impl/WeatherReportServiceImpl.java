package com.lomofu.weatherreportserver.service.Impl;

import com.lomofu.weatherreportserver.service.DataClient;
import com.lomofu.weatherreportserver.service.WeatherReportService;
import com.lomofu.weatherreportserver.vo.Weather;
import com.lomofu.weatherreportserver.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityName(String cityName) {

        WeatherResponse weatherResponse = dataClient.getDataByCityName(cityName);
        Weather data = weatherResponse.getData();
        return data;
    }
}
