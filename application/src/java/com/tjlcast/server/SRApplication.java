package com.tjlcast.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by tangjialiang on 2017/12/19.
 *
 */

@SpringBootApplication
//@MapperScan("com.tjlcsat.mapper")
//@ImportResource({"classpath:spring-context.xml"})
//@DisconfFile(filename = "application.yml")
public class SRApplication {
    public static void main(String[] args) {
        SpringApplication.run(SRApplication.class, args);
    }
}
