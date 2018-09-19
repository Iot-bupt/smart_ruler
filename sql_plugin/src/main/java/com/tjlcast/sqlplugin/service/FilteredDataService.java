package com.tjlcast.sqlplugin.service;

import com.tjlcast.basePlugin.service.DefaultService;
import com.tjlcast.sqlplugin.entity.FilteredData;
import com.tjlcast.sqlplugin.mapper.FilteredDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilteredDataService extends DefaultService {

    @Override
    public Object service(Object[] data) {
        return null;
    }

    @Autowired
    FilteredDataMapper filteredDataMapper;

    public FilteredData insert(FilteredData filteredData){
        this.filteredDataMapper.add(filteredData);
        return filteredData;
    }

    public List<FilteredData> getDataByRule(Integer rule_id){
        return this.filteredDataMapper.getDataByRuleId(rule_id);
    }

    public List<FilteredData> getDataByDevice(String device_id){
        return this.filteredDataMapper.getDataByDeviceId(device_id);
    }

    public void removeDataByRule(Integer rule_id){
        this.filteredDataMapper.removeDataByRuleId(rule_id);
    }

    public void removeDataByDevice(String device_id){
        this.filteredDataMapper.removeDataByDeviceId(device_id);
    }


}
