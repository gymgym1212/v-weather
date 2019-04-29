package com.example.bigdata.controller;

import java.util.concurrent.TimeUnit;

public class MyThread implements Runnable {
    @Override
    public void run() {
        display();
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String change() { return "simple";}
    public static void display() {
        System.out.println("hello");
    }
}
