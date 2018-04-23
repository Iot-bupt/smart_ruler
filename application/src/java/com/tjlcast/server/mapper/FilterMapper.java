package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Filter;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/22.
 */
@Mapper
public interface FilterMapper {
    @Select("select t_filter.* from t_filter2rule_relation, t_filter where t_filter2rule_relation.ruleId=#{ruleId} and t_filter.id=t_filter2rule_relation.filterId")
    List<Filter> findFilterByRuleId(@Param("ruleId") UUID ruleId);

    @Select("select * from t_filter where id=#{id}")
    Filter getAFilter(@Param("id") UUID id) ;

    @Insert("INSERT INTO t_filter(id, jsCode) VALUES(#{id}, #{jsCode})")
    int AddAFilter(Filter filter);

    @Delete("DELETE FROM t_filter WHERE id=#{id}")
    void removeFilter(@Param("id")UUID id) ;

    @Delete("DELETE FROM t_filter")
    void removeAllFilter() ;
}
