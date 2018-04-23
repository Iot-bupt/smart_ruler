package com.tjlcast.server.data;
import lombok.Data;

import java.util.UUID;

/**
 * Created by hasee on 2018/4/16.
 */
@Data
public class Device {
    private UUID id ;               // system唯一id (must)
    private UUID tenantId;          // tenant唯一id (must)
    private String manufacture;     // 厂商
    private String deviceType;      // 设备
    private String model;           // 型号
    private String parentDeviceId;  // 父设备id

    public Device(UUID id, UUID tenantId, String manufacture, String deviceType, String model, String parentDeviceId) {
        this.id = id ;
        this.tenantId = tenantId ;
        this.manufacture = manufacture ;
        this.deviceType = deviceType ;
        this.model = model ;
        this.parentDeviceId = parentDeviceId ;
    }

    public Device(String id, String tenantId, String manufacture, String deviceType, String model, String parentDeviceId) {
        this.id = UUID.fromString(id) ;
        this.tenantId = UUID.fromString(tenantId) ;
        this.manufacture = manufacture ;
        this.deviceType = deviceType ;
        this.model = model ;
        this.parentDeviceId = parentDeviceId ;
    }
}
