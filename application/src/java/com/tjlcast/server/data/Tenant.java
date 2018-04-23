package com.tjlcast.server.data;

import java.util.UUID;

/**
 * Created by hasee on 2018/4/16.
 */
public class Tenant {
    private UUID tenantId;          // Tenant唯一Id
    private String tenantName;      // Tenant的姓名

    public Tenant(UUID tenantId, String tenantName) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
    }

    public Tenant(String tenantId, String tenantName) {
        this.tenantId = UUID.fromString(tenantName);
        this.tenantName = tenantName;
    }
}
