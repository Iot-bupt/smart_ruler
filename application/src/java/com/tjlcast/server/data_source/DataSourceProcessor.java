package com.tjlcast.server.data_source;

import com.tjlcast.server.data.Rule;

/**
 * Created by tangjialiang on 2018/4/22.
 */
public interface DataSourceProcessor {
    void process(FromMsgMiddlerDeviceMsg msg) ;

    void process(Rule rule);
}
