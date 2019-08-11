package com.lomofu.weatherdataserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 数据采集服务
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WeatherDataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherDataServerApplication.class, args);
    }

}
