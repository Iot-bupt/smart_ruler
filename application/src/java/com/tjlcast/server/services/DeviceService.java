package com.tjlcast.server.services;

import com.tjlcast.server.data.Device;
import com.tjlcast.server.mapper.DeviceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
