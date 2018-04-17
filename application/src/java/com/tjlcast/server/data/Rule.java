package com.tjlcast.server.data;

import lombok.Data;

import java.util.UUID;

/**
 * Created by hasee on 2018/4/16.
 */
@Data
public class Rule {
    private UUID id;
    private UUID tenantId;
    private String name;
    private String jsCode;

    public Rule(UUID id, UUID tenantId, String name, String jsCode){
        this.id=id;
        this.tenantId=tenantId;
        this.name=name;
        this.jsCode=jsCode;

    }
}
