package com.example.bigdata.mapper;

import org.springframework.beans.factory.annotation.Autowired;

public class test {

    @Autowired
    ScreenMapper screenMapper;

    @Autowired
    BarMapper barMapper;

    public static void main(String[] args) {
        test t = new test();
        t.ttt();

    }

    public void ttt() {
        barMapper.deleteById(5,1);
    }
}
