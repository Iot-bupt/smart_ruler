package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Transform;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by tangjialiang on 2018/4/23.
 */
@Mapper
public interface TransformMapper{

    @Select("select * from t_transform")
    List<Transform> findAll();

    @Select("select * from t_transform where id = #{id}")
    Transform findById(Integer id) ;

    @Select("select transform.id, transform.name, transform.url, transform.method from t_transform transform left join t_rule rule on transform.id = rule.transformId where rule.id = #{id}")
    Transform findByRuleId(Integer id) ;

    @Delete("delete from t_transform")
    void deleteAll();

    @Delete("delete from t_transform where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into t_transform(id,name,url,method) VALUES (#{id}, #{name}, #{url}, #{transformId})")
    boolean save(Transform transform);


}
