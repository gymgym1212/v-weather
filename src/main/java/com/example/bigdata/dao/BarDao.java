package com.example.bigdata.dao;

import com.example.bigdata.mapper.BarMapper;
import com.example.bigdata.mapper.LineMapper;
import com.example.bigdata.mapper.ScreenMapper;
import com.example.bigdata.pojo.Bar;
import com.example.bigdata.pojo.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BarDao {
    @Autowired
    LineMapper lineMapper;

    @Autowired
    BarMapper barMapper;

    public void createBar(Bar bar) {
        //Bar bar_in_sql = barMapper.findById(bar.getScreen_id(), bar.getOption_id());
        if(lineMapper.findById(bar.getScreen_id(), bar.getOption_id())!=null) {
            //todo 删除line
            System.out.println("删除line");
            lineMapper.deleteById(bar.getScreen_id(), bar.getOption_id());
        }

        if(null!=barMapper.findById(bar.getScreen_id(), bar.getOption_id())) {
            barMapper.update(bar);
        }else{
            barMapper.add(bar);
        }

    }
}
