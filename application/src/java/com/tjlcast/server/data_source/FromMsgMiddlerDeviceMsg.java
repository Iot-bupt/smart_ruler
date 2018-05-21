package com.tjlcast.server.data_source;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tjlcast.server.aware.DeviceAwareMsg;
import com.tjlcast.server.aware.TenantAwareMsg;
import lombok.Data;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.criteria.From;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2018/4/22.
 */
@Data
public class FromMsgMiddlerDeviceMsg implements TenantAwareMsg, DeviceAwareMsg, Serializable {

    private final JsonObject jsonObj ;  // optional
    private final String deviceId ;     // required
    private final Integer tenantId ;    // required
    private final String deviceType;    // optional
    private final List<Item> items = new LinkedList<>();    // required

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

    public static class Builder {
        String deviceId ;
        int tenantId ;

        JsonObject jsonObj = new JsonObject();  // todo
        String deviceType = "default";          // todo
        List<Item> items = new LinkedList<>();  // todo

        public Builder(int tenantId, String deviceId) {
            this.deviceId = deviceId ;
            this.tenantId = tenantId ;
        }

        public Builder jsonObj(JsonObject jsonObject) {
            this.jsonObj = jsonObject ;
            return this ;
        }
        public Builder deviceType(String deviceType) {
            this.deviceType = deviceType ;
            return this ;
        }
        public Builder items(List<Item> items) {
            if (this.items.size()!=0) this.items.addAll(items) ;
            return this ;
        }
        public Builder aItem(Item item) {
            items.add(item) ;
            return this ;
        }
        public FromMsgMiddlerDeviceMsg build() {
            return new FromMsgMiddlerDeviceMsg(this) ;
        }
    }

    private FromMsgMiddlerDeviceMsg(Builder builder) {
        this.jsonObj = builder.jsonObj ;
        this.deviceId = builder.deviceId ;
        this.tenantId = builder.tenantId ;
        this.deviceType = builder.deviceType ;

        if (builder.items.size()!=0) this.items.addAll(builder.items) ;
    }

}
