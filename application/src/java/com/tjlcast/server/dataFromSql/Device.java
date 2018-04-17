package com.tjlcast.server.dataFromSql;

import javax.persistence.Entity;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/16.
 */
@Entity
public class Device {
    private UUID deviceId;
    private String name;
    private UUID tenantId;

    public Device()
    {

    }

    public UUID getDeviceId()
    {
        return deviceId;
    }


    public UUID getTenantId()
    {
        return tenantId;
    }
}
