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

    @Select("select * from transform where id = #{id}")
    Transform findById(Integer id) ;

    @Select("select transform.id, transform.name, transform.url, transform.method from transform transform left join t_rule rule on transform.id = rule.transformId where rule.id = #{id}")
    Transform findByRuleId(Integer id) ;

    @Delete("delete from transform")
    void deleteAll();

    @Delete("delete from transform where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into transform(name,url,method) VALUES (#{name}, #{url}, #{transformId})")
    @Options(useGeneratedKeys = true, keyProperty = "transformId", keyColumn = "transformId")
    int save(Transform transform);


}
