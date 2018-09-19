package com.tjlcast.sqlplugin.entity;

import com.google.gson.JsonObject;
import lombok.Data;

@Data
public class FilteredData {

    private Integer rule_id;
    private String device_id;
    private String telemetry_key;
    private Long ts;
    private Boolean bool_v;
    private String str_v;
    private Long long_v;
    private Double dbl_v;

    public FilteredData(Integer rule_id, String device_id, String telemetry_key, Long ts,
                        Boolean bool_v, String str_v, Long long_v, Double dbl_v) {
        this.rule_id = rule_id;
        this.device_id = device_id;
        this.telemetry_key = telemetry_key;
        this.ts = ts;
        this.bool_v = bool_v;
        this.str_v = str_v;
        this.long_v = long_v;
        this.dbl_v = dbl_v;
    }

    public FilteredData(JsonObject jsonObject){
        this.rule_id = jsonObject.get("rule_id").getAsInt();
        this.device_id = jsonObject.get("device_id").getAsString();
        this.telemetry_key = jsonObject.get("telemetry_key").getAsString();
        this.ts = jsonObject.get("ts").getAsLong();
        this.bool_v = jsonObject.has("dbl_v")? jsonObject.get("bool_v").getAsBoolean():null;
        this.str_v = jsonObject.has("str_v")?jsonObject.get("str_v").getAsString():null;
        this.long_v = jsonObject.has("long_v")?jsonObject.get("long_v").getAsLong():null;
        this.dbl_v = jsonObject.has("dbl_v")? jsonObject.get("dbl_v").getAsDouble():null;


    }

}
