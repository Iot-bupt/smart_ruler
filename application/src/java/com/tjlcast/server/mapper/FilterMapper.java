package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Filter;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/22.
 */
public interface FilterMapper {
    @Select("select filter.jsCode from filter where filter.id = relation.filterid and relation.ruleId = #{ruleId}")
    List<Filter> findFilterByRuleId(@Param("ruleId") UUID ruleId);

}
