package com.tjlcast.server.services;

import com.tjlcast.server.data.Plugin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

//import lombok.Value;

/**
 * Created by tangjialiang on 2018/5/4.
 */
@Service
@Slf4j
//@DisconfFile(filename = "application.yml")
public class PluginManagerService implements InitializingBean {

    @Value("${zookeeper.address}")
    String zkAddress ;

    PluginDiscovery pluginDiscovery ;

    /*@DisconfFileItem(name = "zookeeper.address", associateField = "zkAddress")
    public String getZkAddress() {
        return zkAddress;
    }

    public void setHost(String zkAddress) {
        this.zkAddress = zkAddress;
    }*/


    public List<Plugin> getPluginsInfo() {
        return pluginDiscovery.discover() ;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        pluginDiscovery = new PluginDiscovery(zkAddress) ;
    }
}
