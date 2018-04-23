package com.tjlcast.server.mapper;

import com.tjlcast.server.data.Transform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by tangjialiang on 2018/4/23.
 */
@Repository
public interface TransformRepository extends JpaRepository<Transform, UUID> {
    Transform findById(UUID id) ;

}
