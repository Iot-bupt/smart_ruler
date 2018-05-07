package com.tjlcast.server.data_source;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tjlcast.server.aware.DeviceAwareMsg;
import com.tjlcast.server.aware.TenantAwareMsg;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2018/4/22.
 */
@Data
public class FromMsgMiddlerDeviceMsg implements TenantAwareMsg, DeviceAwareMsg, Serializable {

    private final JsonObject jsonObj ;
    private final String deviceId ;
    private final Integer tenantId ;
    private final String deviceType;
    private final List<Item> items = new LinkedList<>();

    public FromMsgMiddlerDeviceMsg(JsonObject jsonObj) {
        this.jsonObj = jsonObj ;
        this.deviceId = jsonObj.get("deviceId").getAsString() ;
        this.tenantId = Integer.valueOf(jsonObj.get("tenantId").getAsString()) ;
        this.deviceType = jsonObj.get("deviceType").getAsString();

        jsonObj.getAsJsonArray("data").forEach(x -> items.add(new Item((JsonObject) x)));
    }

    public FromMsgMiddlerDeviceMsg(String str) {
        this(new JsonParser().parse(str).getAsJsonObject()) ;
    }

    @Override
    public Integer getTenantId() {
        return this.tenantId ;
    }

    @Override
    public String getDeviceId() {
        return this.deviceId ;
    }

}
