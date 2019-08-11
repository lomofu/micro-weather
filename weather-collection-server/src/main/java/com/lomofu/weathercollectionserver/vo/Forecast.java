package com.lomofu.weathercollectionserver.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 未来天气
 */
@Data
public class Forecast implements Serializable {
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
