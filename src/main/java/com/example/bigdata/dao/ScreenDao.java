package com.example.bigdata.dao;

import com.example.bigdata.mapper.BarMapper;
import com.example.bigdata.mapper.LineMapper;
import com.example.bigdata.mapper.ScreenMapper;
import com.example.bigdata.pojo.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScreenDao {
    @Autowired
    ScreenMapper screenMapper;

    @Autowired
    BarMapper barMapper;

    @Autowired
    LineMapper lineMapper;



    //public static final String URL = "http://47.96.3.244:8000/screen/";

    //public static final String URL = "http://localhost:8000/";
    public static final String URL = "/template";

    public void createScreen(String screen_name, String screen_blocks) {
        int screen_id = screenMapper.findLargestScreenId() + 1;

        Screen screen = new Screen(screen_id, screen_name,URL + screen_blocks + "/" + screen_id, screen_blocks);
        screenMapper.add(screen);

    }

    public void deleteScreen(int screen_id) {
        screenMapper.deleteById(screen_id);
        barMapper.deleteOnlyById(screen_id);
        lineMapper.deleteOnlyById(screen_id);
    }


}
