package com.example.bigdata.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.bigdata.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ApiService {

    /**
     *
     * @param province 地级市 如杭州市
     * @param date 某个时间点 如2019-03-14 14:00:00
     * @return
     */
    public Map<String, Object> getProvinceAirInfo(String province, String date) {
        //d01d19c3d82247a1a9548f2a258e688f
        String host = "https://api.epmap.org";
        String path = "/api/v1/air/city";
        String method = "GET";
        String appcode = "d01d19c3d82247a1a9548f2a258e688f";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("city", province);
        querys.put("pubtime", date);

        Map<String, Object> airInfo = null;
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
            JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
            airInfo = jsonObject.getJSONObject("data");

            /*
            for(Map.Entry<String, Object> entry:airInfo.entrySet()) {
                System.out.println(String.format("[%s:%s]", entry.getKey(), entry.getValue()));
            }
            */

        } catch (Exception e) {
            e.printStackTrace();
        }

        return airInfo;
    }



    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        Map<String, Object> info = apiService.getProvinceAirInfo("杭州市", "2019-03-17 14:00:00");
        for(Map.Entry<String, Object> entry:info.entrySet()) {
            System.out.println(String.format("[%s:%s]", entry.getKey(), entry.getValue()));
        }
    }
}
