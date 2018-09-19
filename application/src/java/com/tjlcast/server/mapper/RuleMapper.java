package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Rule;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by hasee on 2018/4/17.
 */

@Mapper
public interface RuleMapper {
    @Select("select * from rule where ruleId=#{ruleId}")
    Rule findRuleById(@Param("ruleId")Integer ruleId) ;

    @Select("select * from rule where tenantId=#{tenantId}")
    List<Rule> findRuleByTenantId(@Param("tenantId")Integer tenantId);

    @Select("select * from rule where tenantId=#{tenantId} and name like CONCAT('%',#{textSearch},'%')")
    List<Rule> findRuleByTenantIdAndText(@Param("tenantId")Integer tenantId, @Param("textSearch")String textSearch);

    @Select("select * from rule")
    List<Rule> getAllRule();

    @Insert("INSERT INTO rule(tenantId, additional_info, name, state) VALUES(#{tenantId}, #{additional_info}, #{name}, #{state})")
    @Options(useGeneratedKeys = true, keyProperty = "ruleId", keyColumn = "ruleId")
    int addARule(Rule rule);

    @Delete("DELETE FROM rule WHERE ruleId = #{ruleId}")
    void removeRule(Integer ruleId);

    @Delete("DELETE FROM rule")
    void removeAllRule() ;

    @Update("UPDATE rule SET state = 'ACTIVE' WHERE ruleId = #{ruleId}")
    void setRuleActive(Integer ruleId);

    @Update("UPDATE rule SET state = 'SUSPEND' WHERE ruleId = #{ruleId}")
    void setRuleSuspend(Integer ruleId);

    @Update("UPDATE rule SET name = #{name}, additional_info = #{additional_info} WHERE ruleId = #{ruleId}")
    Integer updateRule(Rule rule);
}
