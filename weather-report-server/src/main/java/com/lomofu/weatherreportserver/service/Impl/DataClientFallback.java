package com.lomofu.weatherreportserver.service.Impl;

import com.lomofu.weatherreportserver.service.DataClient;
import com.lomofu.weatherreportserver.vo.City;
import com.lomofu.weatherreportserver.vo.WeatherResponse;
import org.springframework.stereotype.Component;
import java.util.List;

/***
 * 熔断机制
 */
@Component
public class DataClientFallback implements DataClient {
    @Override
    public List<City> cityList() {
        return null;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        return null;
    }
}
