package com.tjlcast.server.data.GenerateData;

import com.tjlcast.server.data_source.FromMsgMiddlerDeviceMsg;
import com.tjlcast.server.data_source.Item;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.kafka.core.KafkaTemplate;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by tangjialiang on 2018/5/22.
 */
public abstract class DefaultGenerator implements Runnable {
    protected KafkaTemplate kafkaTemplate;

    private final int interTime ;

    public DefaultGenerator(int interTime,KafkaTemplate kafkaTemplate) {
        this.interTime = interTime ;
        this.kafkaTemplate = kafkaTemplate;
    }

    private Observable<FromMsgMiddlerDeviceMsg> observe() {
        return Observable
                .interval(interTime, TimeUnit.MILLISECONDS)
                .delay(x -> Observable.timer(RandomUtils.nextInt(0, 10), TimeUnit.MICROSECONDS))
                .map(this::generateRandDeviceIdMsg)
                .map(this::occasionallyKV)
                .subscribeOn(Schedulers.trampoline())
                .observeOn(Schedulers.io());
    }

    protected abstract void work(FromMsgMiddlerDeviceMsg msg) ;

    private void consume() {
        observe()
                .subscribe(
                        this::work,
                        e -> System.out.println("Error emitting event " + e)
                );
    }

    @Override
    public void run() {
        consume() ;
    }

    private FromMsgMiddlerDeviceMsg generateRandDeviceIdMsg(long time) {
        int devicesNum = 10;    // 10 个设备
        int tenantId = 1;       // tenantId 为1
        return new FromMsgMiddlerDeviceMsg.Builder(tenantId, RandomUtils.nextInt(0, devicesNum)+"")
                .build();
    }

    private FromMsgMiddlerDeviceMsg occasionallyKV(FromMsgMiddlerDeviceMsg msg) {
        String ts = String.valueOf(System.currentTimeMillis()/1000L) ;
        String key = "x" ;
        String value = String.valueOf(RandomUtils.nextInt(0, 101) ) ;

        msg.getData().add(new Item(key, value, ts)) ;
        return msg ;
    }
}