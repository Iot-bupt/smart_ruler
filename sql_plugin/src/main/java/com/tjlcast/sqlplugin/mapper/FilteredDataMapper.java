package com.tjlcast.sqlplugin.mapper;


import com.tjlcast.sqlplugin.entity.FilteredData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FilteredDataMapper {


    @Insert("INSERT INTO filtered_telemetry (rule_id, device_id, telemetry_key, ts, bool_v, str_v, long_v, dbl_v) " +
            "VALUES (#{rule_id}, #{device_id}, #{telemetry_key}, #{ts}, #{bool_v}, #{str_v}, #{long_v}, #{dbl_v})")
    int add(FilteredData data);

   /* @Insert("INSERT INTO filtered_telemetry (rule_id, device_id, telemetry_key, ts, bool_v, str_v, long_v, dbl_v) " +
            "VALUES (#{rule_id}, #{device_id}, #{telemetry_key}, #{ts}, #{str_v})")
    FilteredData addByStr(FilteredData data);

    @Insert("INSERT INTO filtered_telemetry (rule_id, device_id, telemetry_key, ts, bool_v, str_v, long_v, dbl_v) " +
            "VALUES (#{rule_id}, #{device_id}, #{telemetry_key}, #{ts}, #{bool_v}, #{str_v}, #{long_v}, #{dbl_v})")
    FilteredData add(FilteredData data);*/

    @Delete("DELETE FROM filtered_telemetry WHERE rule_id = #{rule_id}")
    void removeDataByRuleId(@Param("rule_id") Integer rule_id);

    @Delete("DELETE FROM filtered_telemetry WHERE device_id = #{device_id}")
    void removeDataByDeviceId(@Param("device_id") String device_id);

    @Select("SELECT * FROM filtered_telemetry WHERE rule_id = #{rule_id}")
    List<FilteredData> getDataByRuleId(@Param("rule_id") Integer rule_id);

    @Select("SELECT * FROM filtered_telemetry WHERE device_id = #{device_id}")
    List<FilteredData> getDataByDeviceId(@Param("device_id") String device_id);




}
