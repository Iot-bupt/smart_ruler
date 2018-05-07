package com.tjlcast.server.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tangjialiang on 2018/5/4.
 */
@Service
@Slf4j
public class PluginManagerService implements InitializingBean {

    @Value("${zookeeper.address}")
    String zkAddress ;

    PluginDiscovery pluginDiscovery ;


    public List<String> getPluginsInfo() {
        return pluginDiscovery.discover() ;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        pluginDiscovery = new PluginDiscovery(zkAddress) ;
    }
}
