package com.tjlcast.server.controller;

import com.tjlcast.server.data.Plugin;
import com.tjlcast.server.services.PluginManagerService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tangjialiang on 2018/5/5.
 */
@Slf4j
@RestController
@RequestMapping("/api/plugin")
public class PluginManagerController {

    @Autowired
    PluginManagerService pluginManagerService ;

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Plugin> getAllPlugins() {
        List<Plugin> pluginsInfo = pluginManagerService.getPluginsInfo();
        return pluginsInfo ;
    }
}
