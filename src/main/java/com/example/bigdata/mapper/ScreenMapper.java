package com.example.bigdata.mapper;

import com.example.bigdata.pojo.Screen;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScreenMapper {

    @Select("select * from screens")
    List<Screen> findAll();

    @Select("select screen_id from screens order by screen_id DESC limit 1")
    Integer findLargestScreenId();

    @Select("select * from screens where screen_id = #{id}")
    Screen findById(int id);

    @Insert("insert into screens (screen_id, screen_name, screen_url, screen_blocks) values (#{screen_id}, #{screen_name}, #{screen_url}, #{screen_blocks} )")
    int add(Screen screen);

    @Delete("delete from screens where screen_id = #{screen_id}")
    void deleteById(int screen_id);


}
