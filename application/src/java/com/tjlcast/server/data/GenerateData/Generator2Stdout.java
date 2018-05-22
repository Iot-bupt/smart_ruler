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

    public static void main(String[] args) throws InterruptedException {
        Generator2Stdout generator2Stdout = new Generator2Stdout(10);
        Thread thread = new Thread(generator2Stdout);
        thread.start();

        Thread.sleep(5000);
        generator2Stdout.subscribe.unsubscribe();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()) ;
        }
    }
}
