package com.tjlcast.server.dataFromSql;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by hasee on 2018/4/16.
 */
public interface TenantRepository extends JpaRepository<Tenant,UUID> {

}
