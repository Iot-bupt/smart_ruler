package com.tjlcast.server.data.GenerateData;

import com.tjlcast.server.data_source.FromMsgMiddlerDeviceMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer_li {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public String kafkaProduce(FromMsgMiddlerDeviceMsg msg){

        kafkaTemplate.send("deviceData","",msg);
        return "success";
    }


}
