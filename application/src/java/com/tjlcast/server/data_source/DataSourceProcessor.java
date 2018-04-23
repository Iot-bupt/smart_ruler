package com.tjlcast.server.data_source;

/**
 * Created by tangjialiang on 2018/4/22.
 */
public interface DataSourceProcessor {
    void process(FromMsgMiddlerDeviceMsg msg) ;
}
