package com.tjlcast.server.data;

import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/16.
 */
@Data
public class Rule {
    private UUID id;
    private UUID tenantId;
    private String rulerName;
    private List<UUID> filters;

    public Rule(UUID id, UUID tenantId, String rulerName, String jsCode){
        this.id=id;
        this.tenantId=tenantId;
        this.rulerName=rulerName;
    }
}
