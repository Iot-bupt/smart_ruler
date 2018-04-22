package com.tjlcast.server.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tjlcast.server.data_source.DataSourceProcessor;
import com.tjlcast.server.data_source.FromMsgMiddlerDeviceMsg;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tangjialiang on 2018/4/22.
 */
@RestController
@RequestMapping("/api/test")
@Slf4j
public class MiddlerMsgController extends BaseContoller {

    @Autowired
    DataSourceProcessor dataSourceProcessor ;

    @ApiOperation(value = "测试：模拟从kafka中拉取数据")
    @RequestMapping(value = "/deviceMsg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String postDeviceMsg(@RequestBody String jsonStr) {
        log.info("MiddlerMsgController receive a msg : " + jsonStr) ;

        // str 2 obj
        JsonObject jsonObj = (JsonObject)new JsonParser().parse(jsonStr);
        FromMsgMiddlerDeviceMsg fromMsgMiddlerDeviceMsg = new FromMsgMiddlerDeviceMsg(jsonObj);

        dataSourceProcessor.process(fromMsgMiddlerDeviceMsg);

        return "OK" ;
    }
}
