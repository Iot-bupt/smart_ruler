package com.tjlcast.server.services;

import com.google.gson.JsonObject;
import com.tjlcast.server.data.Rule;
import com.tjlcast.server.mapper.RuleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by tangjialiang on 2018/4/13.
 */

@Slf4j
@Service
public class RuleService {

    private RuleMapper ruleMapper;

    public List<Rule> findRuleByTenantId(UUID tenantId)
    {
        return ruleMapper.findRuleByTenantId(tenantId);
    }

    // add
    public boolean addRule(Rule rule) {
        // todo
        return false ;
    }

    public boolean addRule(String ruleStr) {
        // todo
        return false ;
    }

    public boolean addRule(JsonObject ruleJson) {
        // todo
        return false ;
    }

    // remove
    public boolean removeAllRule() {
        // todo
        return false ;
    }

    public boolean removeARule(UUID id) {
        // todo
        return false ;
    }

    // get
    public List<Rule> getAllRule() {
        // todo
        return null ;
    }

    public Rule getARule() {
        // todo
        return null ;
    }
}
