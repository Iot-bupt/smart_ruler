package com.tjlcast.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tangjialiang on 2017/12/19.
 *
 */
@SpringBootApplication
@PropertySource({"classpath:disconf.properties"})
//@ImportResource({"classpath:disconf.xml"})//引入disconf
public class SRApplication {
    ApplicationContext context = new ClassPathXmlApplicationContext("disconf.xml");
    public static void main(String[] args) {
        SpringApplication.run(SRApplication.class, args);
    }
}
