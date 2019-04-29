package com.example.bigdata.controller;


import com.example.bigdata.mapper.AirIndexMapper;
import com.example.bigdata.pojo.AirIndex;
import com.example.bigdata.service.ApiService;
import com.example.bigdata.service.ClimateService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DataController {

    @Autowired
    ApiService apiService;

    @Autowired
    ClimateService climateService;

    @Autowired
    AirIndexMapper airIndexMapper;

    @RequestMapping("/json")
    public Object getJson() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "cloud");
        map.put("age", "20");
        return map;
    }

    @RequestMapping("/addJson")
    public void addJson(List<Object> object) {
        System.out.println(object.toString());
    }

    @RequestMapping("/life")
    public Object getLifeIndex() {
        return climateService.getCurrentLifeIndex("1253");
    }

    @RequestMapping("/lifearr")
    public Object getLifeIndexArray(String cityId) {
        return climateService.getCurrentLifeIndexArray(cityId);
    }

    @RequestMapping("/fifth_day_info")
    public Object getFifthDayInfo(String cityId) {
        return climateService.getFifthDay(cityId);
    }

    @RequestMapping("/current_weather")
    public Object getCurrentWeather(String cityId) {
        Object obj = null;
        try{
            obj =  climateService.getCurrentWeather(cityId);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            return obj;
        }
    }

    @RequestMapping("/aqi")
    public Object getAQI(String cityId) { return climateService.getAQI(cityId);}

    /**
     * 通过cityId获取空气质量指数
     * @param cityId
     * @return
     */
    @RequestMapping("/getAqi")
    public Object getAqiByCityId(String cityId) {
        return climateService.getAQI(cityId);
    }

    @RequestMapping("/mysql/airindex")
    public Object getMysqlAirIndex(String city) {
        AirIndex airIndex = airIndexMapper.findByCity(city);
        Map<String, Object> info = new HashMap<>();
        info.put("city", city);
        info.put("co", airIndex.getCo());
        info.put("no2", airIndex.getNo2());
        info.put("so2", airIndex.getSo2());
        info.put("o3", airIndex.getO3());
        return info;
    }

}
