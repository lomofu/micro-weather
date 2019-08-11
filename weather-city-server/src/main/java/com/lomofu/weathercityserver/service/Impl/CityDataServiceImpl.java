package com.lomofu.weathercityserver.service.Impl;

import com.lomofu.weathercityserver.service.CityDataService;
import com.lomofu.weathercityserver.util.XmlBuilder;
import com.lomofu.weathercityserver.vo.City;
import com.lomofu.weathercityserver.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> getCityList() throws Exception {
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf8"));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            stringBuffer.append(line);
        }
        bufferedReader.close();

        CityList cityList = (CityList) XmlBuilder.xmlToOb(CityList.class,stringBuffer.toString());
        return cityList.getCityList();
    }
}
