package com.lomofu.weatherreportserver.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 昨日天气
 */
@Data
public class Yesterday implements Serializable {
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
