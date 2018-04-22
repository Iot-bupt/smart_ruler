package com.tjlcast.server.mapper;

import org.apache.ibatis.annotations.*;

import com.tjlcast.server.data.Device;

import java.util.UUID;

/**
 * Created by hasee on 2018/4/17.
 */
@Mapper
public interface DeviceMapper {
    @Select("select * from t_device where id = #{id}")
    Device findDeviceById(@Param("id") UUID id );

    @Insert("INSERT INTO t_device(id, tenantId, manufacture, deviceType, model, parentDeviceId) VALUES(#{id}, #{password}, #{tenantId}, #{manufacture}, #{deviceType}, #{model}, #{parentDeviceId})")
    int insertByDevice(Device device);

    @Delete("DELETE FROM t_device WHERE id = #{id}")
    void delete(UUID id);
}
