package com.tjlcast.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tjlcast.server.data.Device;

import java.util.UUID;

/**
 * Created by hasee on 2018/4/17.
 */
@Mapper
public interface DeviceMapper {
    @Select("select * from device where id = #{id}")
    Device findDeviceById(@Param("id") UUID id );
}
