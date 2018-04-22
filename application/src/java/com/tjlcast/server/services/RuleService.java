package com.tjlcast.server.services;

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

    // remove

    // get
}
