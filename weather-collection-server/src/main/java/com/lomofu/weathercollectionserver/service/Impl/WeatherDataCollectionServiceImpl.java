package com.lomofu.weathercollectionserver.service.Impl;

import com.lomofu.weathercollectionserver.service.WeatherDataCollectionService;
import com.lomofu.weathercollectionserver.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?city=";

    private final long TIME_OUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void sysncDataByCityName(String cityName) {
        String URL = WEATHER_URL +cityName;
        this.saveWeatherData(URL);
    }

    private void saveWeatherData(String URL){
        String key = URL;
        String strbody = null;
        WeatherResponse weatherResponse = null;
        ValueOperations valueOperations = stringRedisTemplate.opsForValue();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL,String.class);
        strbody = responseEntity.getBody();
        if (responseEntity.getStatusCodeValue() == 200){
            valueOperations.set(key,strbody,TIME_OUT, TimeUnit.SECONDS);
            log.info("数据写入成功");
        }
    }
}
