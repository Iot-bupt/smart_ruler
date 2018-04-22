package com.tjlcast.server.services;

import com.tjlcast.server.data.Filter;
import com.tjlcast.server.mapper.FilterMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/22.
 */
@Slf4j
@Service
public class FilterService {
    private FilterMapper filterMapper;

    public List<Filter> findFilterByRuleId(UUID ruleId)
    {
        return filterMapper.findFilterByRuleId(ruleId);
    }
}
