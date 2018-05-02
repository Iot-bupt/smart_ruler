package com.tjlcast.server.data;

import lombok.Data;

/**
 * Created by hasee on 2018/4/16.
 */
@Data
public class Rule {
    private Integer id;                // rule 的唯一Id
    private Integer tenantId;          // 该tule的拥有者
    private String name;       // 该rule的信息
    private Integer transformId;
    //private List<UUID> filters;     // 该rule配置的filter

    public Rule(Integer id, Integer tenantId, String name ,Integer transformId){
        this.id=id;
        this.tenantId=tenantId;
        this.name=name;
        this.transformId=transformId;
    }

    public Rule(String id, String tenantId, String name){
        this.id=Integer.valueOf(id);
        this.tenantId=Integer.valueOf(tenantId);
        this.name=name;
    }
}
