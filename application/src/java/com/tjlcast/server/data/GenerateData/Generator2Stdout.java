package com.tjlcast.server.data.GenerateData;

import com.google.gson.Gson;
import com.tjlcast.server.data_source.FromMsgMiddlerDeviceMsg;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by tangjialiang on 2018/5/22.
 */

public class Generator2Stdout extends DefaultGenerator {


    public Generator2Stdout(int interTime, KafkaTemplate kafkaTemplate) {
        super(interTime, kafkaTemplate);
    }

    @Override
    protected void work(FromMsgMiddlerDeviceMsg msg) {
        System.out.println(Thread.currentThread().getName()) ;
        System.out.println(msg) ;

        Gson gs = new Gson();
        String ObjectStr = gs.toJson(msg);
        System.out.println(ObjectStr);

        String jsonStr = ObjectStr.replaceAll("\"jsonObj\":\\{\\},","");
        System.out.println(jsonStr);
        kafkaTemplate.send("deviceData","",jsonStr);
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
