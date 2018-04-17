package com.tjlcast.server.data;

import javax.persistence.Entity;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/16.
 */
@Entity
public class Tenant {
    private UUID tenantId;
    private String name;

    public Tenant(){

    }

    public UUID getTenantId()
    {
        return tenantId;
    }

    public String getName()
    {
        return name;
    }


}
