package com.example.bigdata.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Api {

    @RequestMapping("/api/getJson")
    public Object getJson() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "cloud");
        map.put("number", "201632120129");
        return map;
    }
}
