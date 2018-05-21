package com.tjlcast.server.data.GenerateData;

import com.tjlcast.server.data_source.FromMsgMiddlerDeviceMsg;

/**
 * Created by tangjialiang on 2018/5/22.
 */
public class Generator2Stdout extends DefaultGenerator {

    public Generator2Stdout(int interTime) {
        super(interTime);
    }

    @Override
    protected void work(FromMsgMiddlerDeviceMsg msg) {
        System.out.println(Thread.currentThread().getName()) ;
        System.out.println(msg) ;
    }
}
