package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Rule;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by hasee on 2018/4/17.
 */

@Mapper
public interface RuleMapper {
    @Select("select * from t_rule where id=#{Id}")
    Rule findRuleById(@Param("Id")Integer id) ;

    @Select("select * from t_rule where tenantId=#{tenantId}")
    List<Rule> findRuleByTenantId(@Param("tenantId")Integer tenantId);

    @Select("select * from t_rule")
    List<Rule> getAllRule();

    @Insert("INSERT INTO t_rule(id, tenantId, name) VALUES(#{id}, #{tenantId}, #{name})")
    int addARule(Rule rule);

    @Delete("DELETE FROM t_rule WHERE id = #{id}")
    void removeRule(Integer id);

    @Delete("DELETE FROM t_rule")
    void removeAllRule() ;
}
