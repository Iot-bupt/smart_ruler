package com.tjlcast.server.dataFromSql;

import javax.persistence.Entity;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/16.
 */
@Entity
public class Rule {
    private UUID ruleId;
    private UUID tenantId;
    private String name;
    private String jsCode;

    public Rule(){

    }

    public UUID getRuleId()
    {
        return ruleId;
    }

    public UUID getTenantId()
    {
        return tenantId;
    }
}
