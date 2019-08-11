package com.lomofu.weathercollectionserver.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * xml 转为javaBean
 * xmlrootElement 为根元素
 * 详情对照文本
 */
@Data


public class City {

    private String cityId;
    private String cityname;
    private String cityCode;
    private String province;
}
