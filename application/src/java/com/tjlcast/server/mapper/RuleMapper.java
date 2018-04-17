package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Rule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.UUID;

/**
 * Created by hasee on 2018/4/17.
 */
@Mapper
public interface RuleMapper {
    @Select("select * from rule where tenantid= #{tenantId}")
    List<Rule> findRuleByTenantId(@Param("tenantId")UUID tenantId);
}
