package com.tjlcast.server.controller;

import com.tjlcast.server.data.Plugin;
import com.tjlcast.server.services.PluginManagerService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    //获取全部插件信息
    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Plugin> getAllPlugins() {
        return pluginManagerService.getPluginsInfo();
    }


    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/state/{url}/{port}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getPluginState(@PathVariable("url") String url,@PathVariable("port") String port) throws IOException {
        return pluginManagerService.getPluginState(url, port);
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/active/{url}/{port}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String activate(@PathVariable("url") String url, @PathVariable("port") String port) throws IOException {
        return pluginManagerService.activate(url, port) ;
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/suspend/{url}/{port}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String suspend(@PathVariable("url") String url, @PathVariable("port") String port) throws IOException {
        return pluginManagerService.suspend(url, port) ;
    }
}
