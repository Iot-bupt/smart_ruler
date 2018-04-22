package com.tjlcast.server.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tangjialiang on 2018/4/22.
 */
@RestController
@RequestMapping("/api/test")
@Slf4j
public class DeviceMsgController extends BaseContoller {

    @ApiOperation(value = "测试：模拟从kafka中拉取数据")
    @RequestMapping(value = "/deviceMsg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String postDeviceMsg(@RequestBody String json) {
        // todo
        // 1. 收到从kafka的数据

        // 2. 对数据进行decode -> JsonObject

        // 3. 把消息[JsonObject]传递到Akka中

        return "OK" ;
    }
}
