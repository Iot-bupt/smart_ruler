package com.tjlcast.server.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tjlcast.server.data.Rule;
import com.tjlcast.server.mapper.RuleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by tangjialiang on 2018/4/13.
 */

@Slf4j
@Service
public class RuleService {

    @Autowired
    RuleMapper ruleMapper;

    public List<Rule> findRuleByTenantId(Integer tenantId)
    {
        return ruleMapper.findRuleByTenantId(tenantId);
    }

    public Rule findRuleById(Integer ruleId)
    {
        return ruleMapper.findRuleById(ruleId);
    }
    // add
    public boolean addRule(Rule rule) {
        ruleMapper.addARule(rule) ;
        return true ;
    }

    public boolean addRule(JsonObject ruleJson) {
        Rule rule = new Gson().fromJson(ruleJson, Rule.class);
        return addRule(rule) ;
    }

    // remove
    public boolean removeAllRule() {
        ruleMapper.removeAllRule();
        return true ;
    }

    public boolean removeARule(Integer id) {
        ruleMapper.removeRule(id);
        return true ;
    }

    // get
    public List<Rule> getAllRule() {
        List<Rule> allRule = ruleMapper.getAllRule();
        return allRule ;
    }

}
