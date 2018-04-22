package com.tjlcast.server.services;

import com.google.gson.JsonObject;
import com.tjlcast.server.data.Device;
import com.tjlcast.server.mapper.DeviceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/17.
 */
@Slf4j
@Service
public class DeviceService {

    private DeviceMapper deviceMapper;

    public Device findDeviceById(UUID deviceId){
        return deviceMapper.findDeviceById(deviceId);
    }

    public boolean addDevice(JsonObject jsonObj) {
        // todo
        return false ;
    }

    public boolean addDevice(Device device) {
        // todo
        return false ;
    }

    public Device getADevice(UUID id) {
        // todo
        return null ;
    }

    public Device getDevice(UUID id) {
        // todo
        return null ;
    }

    public List<Device> allDevice() {
        // todo
        return null ;
    }

    public boolean removeAllDevice() {
        // todo
        return false ;
    }

}
