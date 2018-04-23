package com.tjlcast.server.data;

import lombok.Data;

import java.util.UUID;

/**
 * Created by hasee on 2018/4/16.
 */
@Data
public class Rule {
    private UUID id;                // rule 的唯一Id
    private UUID tenantId;          // 该tule的拥有者
    private String rulerName;       // 该rule的信息
    //private List<UUID> filters;     // 该rule配置的filter

    public Rule(UUID id, UUID tenantId, String rulerName){
        this.id=id;
        this.tenantId=tenantId;
        this.rulerName=rulerName;
    }
}
