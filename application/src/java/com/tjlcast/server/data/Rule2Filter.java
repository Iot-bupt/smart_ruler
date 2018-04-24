package com.tjlcast.server.data;

import lombok.Data;

import java.util.UUID;

@Data
public class Rule2Filter {

    private UUID ruleId;
    private UUID filterId;

    public Rule2Filter(UUID ruleId,UUID filterId){
        this.ruleId=ruleId;
        this.filterId=filterId;
    }
}
