package com.tjlcast.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Created by tangjialiang on 2017/12/19.
 *
 */

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@MapperScan("com.tjlcast.server.mapper.*Mapper")
public class SRApplication {
    public static void main(String[] args) {
        SpringApplication.run(SRApplication.class, args);
    }
}
