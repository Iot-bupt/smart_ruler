package com.tjlcast.server.message;

import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by tangjialiang on 2017/12/19.
 */

@ToString
public class DeviceRecognitionMsg implements Serializable{

    private final UUID deviceId;
    private final String deviceName;
    private final String key;
    private final String ts;
    private final Double value;

    public DeviceRecognitionMsg(UUID deviceId, String deviceName, String key, String ts, Double value) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.key = key;
        this.ts = ts;
        this.value = value;
    }


    //@Override
    public UUID getDeviceId() {
        return deviceId;
    }

    public  String getDeviceName(){
        return deviceName;
    }

    public  String getTs()
    {
        return ts;
    }


    public String getKey()
    {
        return key;
    }

    public Double getValue()
    {
        return  value;
    }


    /**
    @Override
    public UUID getTenantId() {
        return device.getTenantId();
    }

    public String getManufacture() {
        return manufacture;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getModel() {
        return model;
    }
    **/
}
