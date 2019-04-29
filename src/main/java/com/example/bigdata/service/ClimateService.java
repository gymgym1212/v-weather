package com.example.bigdata.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bigdata.dataapi.ClimateByCityId;
import com.example.bigdata.utils.HttpUtils;
import javafx.beans.binding.ObjectBinding;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ClimateService {


    private ClimateByCityId climateByCityId = new ClimateByCityId();

    private static final String LIFE_INDEX_TOKEN = "5944a84ec4a071359cc4f6928b797f91";

    private static final String CURRENT_WEATHER_TOKEN = "50b53ff8dd7d9fa320d3d3ca32cf8ed1";

    private static final String AQI_TOKEN = "8b36edf8e3444047812be3a59d27bab9";

    private static final String FIFTH_DAY_TOKEN = "f9f212e1996e79e0e602b08ea297ffb0";

    private static String getCurrentDate() {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return sdf.format(date);
    }
    /**
     *
     * @param cityId
     * @return
     */


    public Map<String, Object> getCurrentLifeIndex(String cityId) {
        return climateByCityId.getDataByCityId(LIFE_INDEX_TOKEN, cityId);
    }

    public List<Object> getCurrentLifeIndexArray(String cityId) {
        return climateByCityId.getDataByCityId(LIFE_INDEX_TOKEN, cityId).getJSONObject("liveIndex").getJSONArray(getCurrentDate());
    }

    public List<Object> getFifthDay(String cityId) {
        return climateByCityId.getDataByCityId(FIFTH_DAY_TOKEN, cityId).getJSONArray("forecast");
    }

    public Map<String, Object> getCurrentWeather(String cityId) {
        return climateByCityId.getDataByCityId(CURRENT_WEATHER_TOKEN, cityId);
    }

    public Map<String, Object> getAQI(String cityId) {
        return climateByCityId.getDataByCityId(AQI_TOKEN, cityId);
    }

    public static void main(String[] args) {
        ClimateService climateService = new ClimateService();

    }



 /*   *//**
         * 获取生活指数
         * @param lat 经度
         * @param lon 纬度
         * @return
         *//*
        public Map<String, Object> getLifeIndex(String lat, String lon) {
            return (JSONObject)getClimateInfo(lat, lon, LIFEINDEX_TOKEN).getJSONObject("liveIndex").getJSONArray("2019-03-17").get(0);
        }

        public List<Object> getLifeIndexArray(String lat, String lon) {
            return getClimateInfo(lat, lon, LIFEINDEX_TOKEN).getJSONObject("liveIndex").getJSONArray("2019-03-17");
        }

        public Map<String, Object> getWeatherRegime(String lat, String lon) {
            return getClimateInfo(lat, lon, WEATHER_REGIME_TOKEN);
        }

        public Map<String, Object> test(String lat, String lon) {
            return null;
        }*/






/*        private JSONObject getClimateInfo(String lat, String lon, String token) {
            String host = "http://aliv8.data.moji.com";
            String path = "/whapi/json/aliweather/index";
            String method = "POST";
            String appcode = "d01d19c3d82247a1a9548f2a258e688f";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            //根据API的要求，定义相对应的Content-Type
            headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            Map<String, String> querys = new HashMap<String, String>();
            Map<String, String> bodys = new HashMap<String, String>();
    *//*            bodys.put("lat", "39.91488908");
                bodys.put("lon", "116.40387397");
                bodys.put("token", "42b0c7e2e8d00d6e80d92797fe5360fd");*//*
            bodys.put("lat", lat);
            bodys.put("lon", lon);
            bodys.put("token", token);


            JSONObject data = null;
            try {
                *//**
                 * 重要提示如下:
                 * HttpUtils请从
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
                 * 下载
                 *
                 * 相应的依赖请参照
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
                 *//*
                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                System.out.println(response.toString());
                JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
                data = jsonObject.getJSONObject("data");

*//*                for(Map.Entry<String, Object> entry:info.entrySet()) {
                    System.out.println(String.format("[%s:%s]", entry.getKey(), entry.getValue()));
                }*//*
            } catch (Exception e) {
                e.printStackTrace();
            }

            return data;
        }*/
}

