package com.tjlcast.server.controller;

import com.tjlcast.server.services.PluginManagerService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/plugin")
@Slf4j
public class PluginController {
    @Autowired
    PluginManagerService pluginManagerService;

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/allPlugins", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<String> getPlugins()
    {
        List<String> allPlugin=pluginManagerService.getPluginsInfo();
        return  allPlugin;
    }
}
