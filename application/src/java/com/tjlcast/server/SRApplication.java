package com.tjlcast.server;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by tangjialiang on 2017/12/19.
 *
 */

@SpringBootApplication
//@MapperScan("com.tjlcsat.mapper")
@ImportResource({"classpath:spring-context"})
@DisconfFile(filename = "smart_ruler.yml")
public class SRApplication {
    public static void main(String[] args) {
        SpringApplication.run(SRApplication.class, args);
    }
}
