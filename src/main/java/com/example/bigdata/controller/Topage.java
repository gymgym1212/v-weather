package com.example.bigdata.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Topage {

    @RequestMapping("/simple")
    public String toSimple() {
        return "simple";
    }


    @RequestMapping("/t1")
    public String toTOne() {
        Thread t1 = new Thread();



        return "index";
    }

}
