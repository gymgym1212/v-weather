package com.example.bigdata.mapper;

import com.example.bigdata.pojo.AirIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AirIndexMapper {

    @Select("select * from air_concentration_avg")
    List<AirIndex> findAll();
//('%',#{0},'%')
    @Select("select * from air_concentration_avg where city = #{city, jdbcType=VARCHAR}")
    AirIndex findByCity(String city);


}
