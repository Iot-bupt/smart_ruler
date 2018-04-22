package com.tjlcast.server.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tangjialiang on 2018/4/13.
 */

@RestController
@RequestMapping("/api/rule")
@Slf4j
public class RuleController extends BaseContoller {

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addRule(@RequestBody String jsonStr) {
        // todo
        // 1. decode the jsonStr to be a jsonObj.
        // 2. add the jsonStr to db.
        return "OK" ;
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String removeRule(@RequestParam String id) {
        // todo
        // 1. remove the rule in db.
        return "OK" ;
    }

}
