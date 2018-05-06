package com.tjlcast.server.data;

import lombok.Data;

/**
 * Created by hasee on 2018/4/16.
 */
@Data
public class Rule {
    private Integer ruleId;                // rule 的唯一Id
    private Integer tenantId;          // 该tule的拥有者
    private String addition_info;
    private String name;       // 该rule的信息
    private String state;
    private Integer transformId;
    //private List<UUID> filters;     // 该rule配置的filter

    public Rule(Integer ruleId, Integer tenantId, String addition_info, String name, String state, Integer transformId){
        this.ruleId=ruleId;
        this.tenantId=tenantId;
        this.addition_info=addition_info;
        this.name=name;
        this.state=state;
        this.transformId=transformId;
    }

    public Rule(String id, String tenantId, String name){
        this.ruleId=Integer.valueOf(id);
        this.tenantId=Integer.valueOf(tenantId);
        this.name=name;
    }
}
