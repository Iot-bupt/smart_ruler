package com.tjlcast.server.controller;

import akka.actor.ActorRef;
import com.alibaba.fastjson.JSONObject;
import com.tjlcast.server.actors.ActorSystemContext;
import com.tjlcast.server.message.DeviceRecognitionMsg;
import org.springframework.web.bind.annotation.*;


/**
 * Created by tangjialiang on 2018/4/13.
 */

@RestController
@RequestMapping("/api")
public class RulerController extends ActorAwareController {

    protected final ActorSystemContext systemContext;

    public RulerController(ActorSystemContext systemContext) {
        this.systemContext = systemContext;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public String ruleProcess(@RequestBody String msg) throws Exception{
        try{
            JSONObject jsonObject=JSONObject.parseObject(msg);
            DeviceRecognitionMsg message=(DeviceRecognitionMsg)JSONObject.toJavaObject(jsonObject,DeviceRecognitionMsg.class);
            ActorRef appActor=systemContext.getAppActor();
            appActor.tell(message,ActorRef.noSender());
            return msg;
        }
        catch(Exception e){
            return "fail";
        }
    }
}
