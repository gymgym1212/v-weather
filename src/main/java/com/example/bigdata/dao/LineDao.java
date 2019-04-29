package com.example.bigdata.dao;


import com.example.bigdata.mapper.BarMapper;
import com.example.bigdata.mapper.LineMapper;
import com.example.bigdata.pojo.Bar;
import com.example.bigdata.pojo.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LineDao {
    @Autowired
    LineMapper lineMapper;

    @Autowired
    BarMapper barMapper;

    public void createLine(Line line) {
        //Bar bar_in_sql = barMapper.findById(bar.getScreen_id(), bar.getOption_id());
        if(barMapper.findById(line.getScreen_id(), line.getOption_id())!=null) {
            //todo 删除bar
            System.out.println("删除bar");
            barMapper.deleteById(line.getScreen_id(), line.getOption_id());
        }

        if(lineMapper.findById(line.getScreen_id(), line.getOption_id())!=null) {
            lineMapper.update(line);
        }else{

            lineMapper.add(line);
        }

    }
}
