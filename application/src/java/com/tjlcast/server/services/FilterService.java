package com.tjlcast.server.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tjlcast.server.data.Filter;
import com.tjlcast.server.mapper.FilterMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/22.
 */

@Slf4j
@Service
public class FilterService {

    @Autowired
    private FilterMapper filterMapper;

    public List<Filter> findFilterByRuleId(UUID ruleId)
    {
        return filterMapper.findFilterByRuleId(ruleId);
    }

    public boolean addFilter(JsonObject filterJson) {
        Filter filter = new Gson().fromJson(filterJson, Filter.class);
        return addFilter(filter) ;
    }

    public boolean addFilter(Filter filter) {
        int i = filterMapper.AddAFilter(filter);
        return i==1 ? true : false ;
    }

    public boolean removeAll() {
        try {
            filterMapper.removeAllFilter();
            return true ;
        } catch (Exception e) {
            return false ;
        }
    }

    public boolean removeAFilter(UUID id) {
        try {
            filterMapper.removeFilter(id);
            return true ;
        } catch (Exception e) {
            return false ;
        }
    }

    public List<Filter> getAllFilter() {
        List<Filter> allFilter = getAllFilter();
        return allFilter ;
    }

    public Filter getAFilter(UUID id) {
        Filter aFilter = filterMapper.getAFilter(id);
        return aFilter ;
    }
}
