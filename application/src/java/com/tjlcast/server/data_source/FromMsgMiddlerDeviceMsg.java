package com.tjlcast.server.data_source;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tjlcast.server.aware.DeviceAwareMsg;
import com.tjlcast.server.aware.TenantAwareMsg;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by tangjialiang on 2018/4/22.
 */
@Data
public class FromMsgMiddlerDeviceMsg implements TenantAwareMsg, DeviceAwareMsg, Serializable {

    private final JsonObject jsonObj ;
    private final UUID deviceId ;
    private final UUID tenantId ;
    private final List<Item> items = new LinkedList<>();

    public FromMsgMiddlerDeviceMsg(JsonObject jsonObj) {
        this.jsonObj = jsonObj ;
        this.deviceId = UUID.fromString(jsonObj.get("deviceId").getAsString()) ;
        this.tenantId = UUID.fromString(jsonObj.get("tenantId").getAsString()) ;

        jsonObj.getAsJsonArray("data").forEach(x -> items.add(new Item((JsonObject) x)));
    }

    public FromMsgMiddlerDeviceMsg(String str) {
        this(new JsonParser().parse(str).getAsJsonObject()) ;
    }

    @Override
    public UUID getTenantId() {
        return this.tenantId ;
    }

    @Override
    public UUID getDeviceId() {
        return this.deviceId ;
    }




    public static void main(String[] args) {
    }
}
