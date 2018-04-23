package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Device;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by hasee on 2018/4/17.
 */
@Mapper
public interface DeviceMapper {
    @Select("select * from t_device where id = #{id}")
    Device findDeviceById(@Param("id") String id );

    @Select("select * from t_device")
    List<Device> getAllDeivce() ;

    @Insert("INSERT INTO t_device(id, tenantId, manufacture, deviceType, model, parentDeviceId) VALUES(#{id}, #{password}, #{tenantId}, #{manufacture}, #{deviceType}, #{model}, #{parentDeviceId})")
    int addDevice(Device device);

    @Delete("DELETE FROM t_device WHERE id = #{id}")
    void removeADevice(String id);

    @Delete("DELETE FROM t_device")
    void removeAllDevice() ;
}
