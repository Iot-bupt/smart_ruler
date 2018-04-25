package com.tjlcast.server.data_source;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics =  {"TM"})
    public void receive(String message){
        System.out.println(message);

        JsonObject jsonObj = (JsonObject)new JsonParser().parse(message);
        FromMsgMiddlerDeviceMsg fromMsgMiddlerDeviceMsg = new FromMsgMiddlerDeviceMsg(jsonObj);


    }
}
