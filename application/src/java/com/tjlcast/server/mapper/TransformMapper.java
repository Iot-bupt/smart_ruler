package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Transform;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by tangjialiang on 2018/4/23.
 */
@Mapper
public interface TransformMapper{

    @Select("select * from t_transform")
    List<Transform> findAll();

    @Select("select * from transform where transformId = #{transformId}")
    Transform findById(Integer transformId) ;

    @Select("select transform.transformId, transform.name, transform.url, transform.method from transform transform left join rule rule on transform.transformId = rule.transformId where rule.ruleId = #{ruleId}")
    Transform findByRuleId(Integer ruleId) ;

    @Delete("delete from transform")
    void deleteAll();

    @Delete("delete from transform where transformId = #{transformId}")
    void deleteById(Integer transformId);

    @Insert("insert into transform(name,url,method) VALUES (#{name}, #{url}, #{method})")
    @Options(useGeneratedKeys = true, keyProperty = "transformId", keyColumn = "transformId")
    int save(Transform transform);


}
