package com.tjlcast.server.controller;

import com.tjlcast.server.actors.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tangjialiang on 2018/4/13.
 */

@Slf4j
public class ActorAwareController {

    @Autowired
    protected ActorService actorService ;

}
