package com.tjlcast.server.controller;

import com.tjlcast.server.actors.ActorSystemContext;
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
            //ActorRef appActor=systemContext.getAppActor();
            //appActor.tell(msg,ActorRef.noSender());
            return msg;
        }
        catch(Exception e){
            return "fail";
        }
    }
}
