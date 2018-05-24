package com.tjlcast.server.services;

import com.tjlcast.server.data.Plugin;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

/**
 * Created by tangjialiang on 2018/5/4.
 */
@Service
@Slf4j
public class PluginManagerService implements InitializingBean {

    @Value("${zookeeper.address}")
    String zkAddress ;

    PluginDiscovery pluginDiscovery ;

    public List<Plugin> getPluginsInfo() {
        return pluginDiscovery.discover() ;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        pluginDiscovery = new PluginDiscovery(zkAddress) ;
    }

    /**
     * 得到Plugin的状态
     * @param url
     * @param port
     * @return
     * @throws IOException
     */
    public String getPluginState(String url, String port) throws IOException {
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

    /**
     * 激活Plugin
     * @param url
     * @param port
     * @return
     * @throws IOException
     */
    public String activate(String url, String port) throws IOException {
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

    /**
     * 暂停Plugin
     * @param url
     * @param port
     * @return
     * @throws IOException
     */
    public String suspend(String url, String port) throws IOException {
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

    public String details(String url, String port) throws IOException {
        String requestAddr = "/api/plugin/details";

        OkHttpClient client = new OkHttpClient() ;
        Request request = new Request.Builder()
                .url("http://" + url + ":" + port + requestAddr)
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

}
