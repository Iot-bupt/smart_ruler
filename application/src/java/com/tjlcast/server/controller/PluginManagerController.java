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
        List<Plugin> pluginsInfo = pluginManagerService.getPluginsInfo();
        return pluginsInfo ;
    }


    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/state/{url}/{port}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getPluginState(@PathVariable("url") String url,@PathVariable("port") String port) throws IOException {
        String requestAddr = "/api/plugin/state";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://"+url+":"+port+requestAddr)
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/active/{url}/{port}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String activate(@PathVariable("url") String url, @PathVariable("port") String port) throws IOException {
        String requestAddr = "/api/plugin/active";

        OkHttpClient client = new OkHttpClient();

        okhttp3.RequestBody body = okhttp3.RequestBody.create(MediaType.parse("application/json; charset=utf-8")
                , "");

        Request request = new Request.Builder()
                .url("http://"+url+":"+port+requestAddr)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/suspend/{url}/{port}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String suspend(@PathVariable("url") String url, @PathVariable("port") String port) throws IOException {
        String requestAddr = "/api/plugin/suspend";

        OkHttpClient client = new OkHttpClient();

        okhttp3.RequestBody body = okhttp3.RequestBody.create(MediaType.parse("application/json; charset=utf-8")
                , "");

        Request request = new Request.Builder()
                .url("http://"+url+":"+port+requestAddr)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}
