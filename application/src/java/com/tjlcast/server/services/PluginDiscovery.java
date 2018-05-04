package com.tjlcast.server.services;


import com.tjlcast.server.common.CollectionUtil;
import com.tjlcast.server.common.Constant;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 基于 ZooKeeper 的服务发现接口实现
 *
 * @author huangyong
 * @since 1.0.0
 */
public class PluginDiscovery {

    private static final Logger LOGGER = LoggerFactory.getLogger(PluginDiscovery.class);

    private String zkAddress;

    public PluginDiscovery(String zkAddress) {
        this.zkAddress = zkAddress;
    }

    public List<String> discover() {
        // 创建 ZooKeeper 客户端
        ZkClient zkClient = new ZkClient(zkAddress, Constant.ZK_SESSION_TIMEOUT, Constant.ZK_CONNECTION_TIMEOUT);
        LOGGER.debug("connect zookeeper");
        List<String> plugins = null ;
        try {
            // 获取 service 节点
            String servicePath = Constant.ZK_REGISTRY_PATH;
            if (!zkClient.exists(servicePath)) {
                throw new RuntimeException(String.format("can not find any service node on path: %s", servicePath));
            }
            List<String> addressList = zkClient.getChildren(servicePath);
            if (CollectionUtil.isEmpty(addressList)) {
                throw new RuntimeException(String.format("can not find any address node on path: %s", servicePath));
            }
            plugins = addressList ;
        } finally {
            zkClient.close();
        }
        return plugins ;
    }
}