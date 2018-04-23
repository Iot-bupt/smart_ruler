package com.tjlcast.server.mapper;

import org.apache.ibatis.annotations.*;

import com.tjlcast.server.data.Device;

import java.util.List;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/17.
 */
@Mapper
public interface DeviceMapper {
    @Select("select * from t_device where id = #{id}")
    Device findDeviceById(@Param("id") UUID id );

    @Select("select * from t_device")
    List<Device> getAllDeivce() ;

    @Insert("INSERT INTO t_device(id, tenantId, manufacture, deviceType, model, parentDeviceId) VALUES(#{id}, #{password}, #{tenantId}, #{manufacture}, #{deviceType}, #{model}, #{parentDeviceId})")
    int addDevice(Device device);

    @Delete("DELETE FROM t_device WHERE id = #{id}")
    void removeADevice(UUID id);

    @Delete("DELETE FROM t_device")
    void removeAllDevice() ;
}
