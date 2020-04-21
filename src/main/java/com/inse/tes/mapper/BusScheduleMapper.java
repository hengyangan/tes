package com.inse.tes.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BusScheduleMapper {

    @Select("select timeline from east")
    List<Integer> eastList();

    @Select("select timeline from west")
    List<Integer> westList();
}
