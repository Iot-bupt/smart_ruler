package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Rule2Filter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Rule2FilterMapper {
    @Insert("INSERT INTO t_filter2rule_relation (ruleId, filterId) VALUES(#{ruleId}, #{filterId})")
    int addARelation(Rule2Filter rule2Filter);
}
