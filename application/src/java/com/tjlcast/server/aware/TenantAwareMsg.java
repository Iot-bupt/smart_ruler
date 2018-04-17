package com.tjlcast.server.aware;

import java.util.UUID;

/**
 * Created by tangjialiang on 2017/12/18.
 */

public interface TenantAwareMsg {

    UUID getTenantId();

}
