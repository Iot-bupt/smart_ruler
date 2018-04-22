package com.tjlcast.server.message;

import java.util.UUID;

/**
 * Created by tangjialiang on 2018/4/22.
 */
public interface TenantAwareMsg {
    public UUID getTenantId() ;
}
