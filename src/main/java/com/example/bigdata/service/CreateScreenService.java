package com.example.bigdata.service;

import com.example.bigdata.jdbc.TestJDBC;
import org.springframework.stereotype.Service;


@Service
public class CreateScreenService {
    public void createScreen() {
        TestJDBC jdbc = new TestJDBC();
        jdbc.createScreen();

    }
}
