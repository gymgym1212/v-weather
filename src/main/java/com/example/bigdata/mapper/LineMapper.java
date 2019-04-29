package com.example.bigdata.mapper;

import com.example.bigdata.pojo.Bar;
import com.example.bigdata.pojo.Line;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LineMapper {
    @Select("select * from `lines`")
    List<Line> findAll();

    @Select("select * from `lines` where screen_id = #{screen_id} and option_id = #{option_id}")
    Line findById(@Param("screen_id") int screen_id, @Param("option_id") int option_id);

    @Select("select * from `lines` where screen_id = #{screen_id}")
    List<Line> findByScreenId(int screen_id);

    @Insert("insert into `lines` (screen_id, option_id, title, color, unit, xaxis, yaxis) values (#{screen_id}, #{option_id}, #{title}, #{color}, #{unit}, #{xaxis},#{yaxis})")
    int add(Line line);

    @Update("update `lines` set title=#{title}, color=#{color}, unit=#{unit}, xaxis=#{xaxis}, yaxis=#{yaxis} where screen_id = #{screen_id} and option_id=#{option_id}")
    int update(Line line);

    @Delete("delete from `lines` where screen_id = #{screen_id} and option_id = #{option_id}")
    void deleteById(@Param("screen_id") int screen_id, @Param("option_id") int option_id);

    @Delete("delete from `lines` where screen_id = #{screen_id}")
    void deleteOnlyById(int screen_id);
}
