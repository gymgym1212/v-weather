package com.example.bigdata.mapper;

import com.example.bigdata.pojo.Bar;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BarMapper {
    @Select("select * from bars")
    List<Bar> findAll();

    @Select("select * from bars where screen_id = #{screen_id} and option_id = #{option_id}")
    Bar findById(@Param("screen_id") int screen_id, @Param("option_id") int option_id);

    @Select("select * from bars where screen_id = #{screen_id}")
    List<Bar> findByScreenId(int screen_id);

    @Insert("insert into bars (screen_id, option_id, title, color, unit, xaxis, yaxis, width) values (#{screen_id}, #{option_id}, #{title}, #{color}, #{unit}, #{xaxis},#{yaxis},#{width})")
    int add(Bar bar);

    @Update("update bars set title=#{title}, color=#{color}, unit=#{unit}, xaxis = #{xaxis}, yaxis=#{yaxis}, width=#{width} where screen_id=#{screen_id} and option_id = #{option_id} ")
    int update(Bar bar);

    @Delete("delete from bars where screen_id = #{screen_id} and option_id = #{option_id}")
    void deleteById(@Param("screen_id") int screen_id, @Param("option_id") int option_id);

    @Delete("delete from bars where screen_id = #{screen_id}")
    void deleteOnlyById(int screen_id);


}
