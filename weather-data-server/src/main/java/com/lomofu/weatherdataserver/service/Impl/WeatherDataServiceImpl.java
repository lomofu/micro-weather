package com.lomofu.weatherdataserver.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lomofu.weatherdataserver.service.WeatherDataService;
import com.lomofu.weatherdataserver.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.omg.DynamicAny.DynValueOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?city=";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URL + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String URL) {
        String key = URL;
        String strBody = null;
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(key)) {
            log.info("缓存中有数据!");
            strBody = ops.get(key);
        } else {
            throw new RuntimeException("没有数据!");
        }

        //将json转化为对象
        try {
            weatherResponse = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.info("Error", e);
        }

        return weatherResponse;
    }
}
