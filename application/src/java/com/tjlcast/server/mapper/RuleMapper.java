package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Device;
import com.tjlcast.server.data.Rule;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/17.
 */
@Mapper
public interface RuleMapper {
    @Select("select * from t_rule where id=#{Id}")
    List<Rule> findRuleById(@Param("Id")UUID id) ;

    @Select("select * from t_rule where tenantid=#{tenantId}")
    List<Rule> findRuleByTenantId(@Param("tenantId")UUID tenantId);

    @Select("select * from t_rule")
    List<Rule> getAllRule();

    @Insert("INSERT INTO t_rule(id, tenantId, rulerName) VALUES(#{id}, #{tenantId}, #{rulerName})")
    int addARule(Rule rule);

    @Delete("DELETE FROM t_rule WHERE id = #{id}")
    void removeRule(UUID id);

    @Delete("DELETE FROM t_rule")
    void removeAllRule() ;
}
