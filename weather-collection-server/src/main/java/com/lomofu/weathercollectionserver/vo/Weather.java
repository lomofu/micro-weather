package com.lomofu.weathercollectionserver.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Weather implements Serializable {
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
