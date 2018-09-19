package com.tjlcast.sqlplugin.controller;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;
import com.tjlcast.basePlugin.aop.ConfirmActive;
import com.tjlcast.basePlugin.common.ZKConstant;
import com.tjlcast.basePlugin.pluginManager.Plugin;
import com.tjlcast.sqlplugin.entity.FilteredData;
import com.tjlcast.sqlplugin.service.FilteredDataService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sqlplugin")
@Plugin(pluginInfo = "sqlPlugin", registerAddr = ZKConstant.ZK_ADDRESS, detailInfo = "sqlplugin:9200|use for saving filtered data")
public class FilteredDataController {

    private final String controllerName = FilteredDataController.class.getSimpleName() ;

    private MetricRegistry metrics ;
    private Counter pendingJobs ;

    @Autowired
    public void setMetrics(MetricRegistry metrics) {
        this.metrics = metrics ;
        this.pendingJobs = this.metrics.counter(controllerName) ;
    }

    @Autowired
    FilteredDataService filteredDataService;


    @ConfirmActive
    @RequestMapping(value=("/insert"), method = RequestMethod.POST)
    public FilteredData insertFilteredData(@RequestBody String data){

        JsonObject jsonObj = (JsonObject)new JsonParser().parse(data);
        FilteredData addData = new FilteredData(jsonObj);
        FilteredData insertData = filteredDataService.insert(addData);

        pendingJobs.inc();

        return insertData;
    }

    @RequestMapping(value = ("/getByRule/{rule_id}"), method = RequestMethod.GET)
    public List<FilteredData> getDataByRule(@PathVariable("rule_id") Integer rule_id){
        List<FilteredData> dataList = filteredDataService.getDataByRule(rule_id);
        return dataList;

    }

    @RequestMapping(value = ("/getByDevice/{device_id}"), method = RequestMethod.GET)
    public List<FilteredData> getDataByRule(@PathVariable("device_id") String device_id){
        List<FilteredData> dataList = filteredDataService.getDataByDevice(device_id);
        return dataList;

    }

    @RequestMapping(value = ("/removeByRule/{rule_id}"), method = RequestMethod.DELETE)
    public void removeByRule(@PathVariable("rule_id") Integer rule_id){
        filteredDataService.removeDataByRule(rule_id);
    }


    @RequestMapping(value = ("/removeByDevice/{device_id}"), method = RequestMethod.DELETE)
    public void removeByDevice(@PathVariable("device_id") String device_id){
        filteredDataService.removeDataByDevice(device_id);
    }

}
