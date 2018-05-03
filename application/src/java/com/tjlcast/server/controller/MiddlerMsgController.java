package com.tjlcast.server.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tjlcast.server.data_source.DataSourceProcessor;
import com.tjlcast.server.data_source.FromMsgMiddlerDeviceMsg;
import com.tjlcast.server.services.FilterService;
import com.tjlcast.server.services.Rule2FilterService;
import com.tjlcast.server.services.RuleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tangjialiang on 2018/4/22.
 */

@RestController
@RequestMapping("/api/test")
@Slf4j
public class MiddlerMsgController extends BaseContoller {

    @Autowired
    Rule2FilterService rule2FilterService;

    @Autowired
    FilterService filterService;

    @Autowired
    RuleService ruleService;

    @Autowired
    DataSourceProcessor dataSourceProcessor ;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @ApiOperation(value = "测试：模拟从kafka中拉取数据")
    @RequestMapping(value = "/deviceMsg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String postDeviceMsg(@RequestBody String jsonStr) {
        log.info("MiddlerMsgController receive a msg : " + jsonStr) ;

        // str 2 obj
        JsonObject jsonObj = (JsonObject)new JsonParser().parse(jsonStr);
        FromMsgMiddlerDeviceMsg fromMsgMiddlerDeviceMsg = new FromMsgMiddlerDeviceMsg(jsonObj);
        /**
        Random random = new Random();
        Rule rule = new Rule((int)(Math.random()*100000),fromMsgMiddlerDeviceMsg.getTenantId(),"Rule"+random.nextInt(),8901);
        ruleService.addRule(rule);

        Filter filter1 = new Filter((int)(Math.random()*100000),"function filter(key,value){if(key=='x' && value>0){ return true;} else{return false;}}");
        filterService.addFilter(filter1);

        Filter filter2 = new Filter((int)(Math.random()*100000),"function filter(key,value){if(key=='x' && value>1){ return true;} else{return false;}}");
        filterService.addFilter(filter2);

        Rule2Filter rule2Filter= new Rule2Filter(rule.getId(),filter1.getId());
        rule2FilterService.addARelation(rule2Filter)
        ;
        Rule2Filter rule2Filter2= new Rule2Filter(rule.getId(),filter2.getId());
        rule2FilterService.addARelation(rule2Filter2);
**/
        dataSourceProcessor.process(fromMsgMiddlerDeviceMsg);

        return "OK" ;
    }

    @ApiOperation(value = "测试：okhttp请求接受成功")
    @RequestMapping(value = "/receive", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String receive(@RequestBody String jsonstr){

        System.out.println(jsonstr);
        return "success";
    }

    @ApiOperation(value = "测试：间隔0.5z一条数据持续发送")
    @RequestMapping(value = "/send", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void queryAllItem() throws InterruptedException {
        while(true) {
            Thread.sleep(500);
            kafkaTemplate.send("TM", "", "{\n" + "\t\"deviceId\": \"1\",\n" + "\t\"tenantId\": \"1\",\n" + "\t\"data\": [{\n" + "\t\t\"key\": \"x\",\n" + "\t\t\"ts\": \"1524708830000\",\n" + "\t\t\"value\": \"2.00\"\n" + "\t}]\n" + "}");
        }

    }

}
